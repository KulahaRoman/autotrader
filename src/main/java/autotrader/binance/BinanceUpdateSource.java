package autotrader.binance;

import autotrader.binance.dto.update.UpdateDTO;
import autotrader.binance.mapper.UpdateMapper;
import autotrader.binance.model.Update;
import autotrader.core.UpdateSource;
import autotrader.util.JSON;
import com.binance.connector.client.SpotClient;
import com.binance.connector.client.WebSocketStreamClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;

import java.util.concurrent.atomic.AtomicReference;

public class BinanceUpdateSource implements UpdateSource<Update> {
    private final WebSocketStreamClient webSocketStreamClient;

    private final AtomicReference<Update> temporaryUpdate = new AtomicReference<>();

    public BinanceUpdateSource(WebSocketStreamClient webSocketStreamClient,
                               SpotClient spotClient) {
        this.webSocketStreamClient = webSocketStreamClient;

        JSONObject obj = new JSONObject(spotClient.createUserData().createListenKey());
        String listenKey = obj.getString("listenKey");

        webSocketStreamClient.listenUserStream(listenKey, ((event) -> {
            try {
                var updateDTO = JSON.readObject(event, UpdateDTO.class);
                var update = UpdateMapper.INSTANCE.toModel(updateDTO);

                temporaryUpdate.set(update);

                synchronized (this) {
                    notify();
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    @Override
    public void close() throws Exception {
        webSocketStreamClient.closeAllConnections();
    }

    @Override
    public Update nextUpdate() throws Exception {
        synchronized (this) {
            try {
                while (temporaryUpdate.get() == null) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var update = temporaryUpdate.get();
        temporaryUpdate.set(null);

        return update;
    }
}
