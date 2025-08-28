package autotrader.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {
    private final ObjectMapper mapper;
    private static JSON instance;

    public JSON() {
        mapper = new ObjectMapper();
    }

    public static <T> T readObject(String data, Class<T> clazz) throws JsonProcessingException {
        var instance = JSON.getInstance();
        synchronized (instance) {
            return instance.mapper.readValue(data, clazz);
        }

    }

    public static <T> T readObject(String data, TypeReference<T> typeReference) throws JsonProcessingException {
        var instance = JSON.getInstance();
        synchronized (instance) {
            return instance.mapper.readValue(data, typeReference);
        }
    }

    public static <T> String writeObject(T object) throws JsonProcessingException {
        var instance = JSON.getInstance();
        synchronized (instance) {
            return instance.mapper.writeValueAsString(object);
        }
    }

    private static JSON getInstance() {
        if (instance == null) {
            instance = new JSON();
        }

        return instance;
    }
}
