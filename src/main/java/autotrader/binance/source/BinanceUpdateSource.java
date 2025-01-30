package autotrader.binance.source;

import autotrader.binance.dto.update.UpdateDTO;
import autotrader.binance.mapper.UpdateMapper;
import autotrader.binance.model.update.Update;
import autotrader.core.UpdateSource;
import autotrader.util.JSON;
import com.binance.connector.client.SpotClient;
import com.binance.connector.client.WebSocketStreamClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinanceUpdateSource implements UpdateSource<Update> {
    private final BlockingQueue<Update> updates = new LinkedBlockingQueue<>();

    public BinanceUpdateSource(WebSocketStreamClient webSocketStreamClient, SpotClient spotClient) {
        JSONObject obj = new JSONObject(spotClient.createUserData().createListenKey());
        String listenKey = obj.getString("listenKey");

        webSocketStreamClient.listenUserStream(listenKey, ((event) -> {
            try {
                var updateDTO = JSON.readObject(event, UpdateDTO.class);
                updates.put(UpdateMapper.toModel(updateDTO));
            } catch (JsonProcessingException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    @Override
    public Update nextUpdate() {
        try {
            return updates.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
