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

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BinanceUpdateSource implements UpdateSource<Update> {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final AtomicReference<Update> temporaryUpdate = new AtomicReference<>();

    public BinanceUpdateSource(WebSocketStreamClient webSocketStreamClient, SpotClient spotClient) {
        JSONObject obj = new JSONObject(spotClient.createUserData().createListenKey());
        String listenKey = obj.getString("listenKey");

        webSocketStreamClient.listenUserStream(listenKey, ((event) -> {
            try {
                var updateDTO = JSON.readObject(event, UpdateDTO.class);
                var update = UpdateMapper.toModel(updateDTO);

                temporaryUpdate.set(update);

                lock.lock();
                try {
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    @Override
    public Update nextUpdate() {
        lock.lock();
        try {
            while (temporaryUpdate.get() == null) {
                condition.await();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

        var update = temporaryUpdate.get();
        temporaryUpdate.set(null);

        return update;
    }
}
