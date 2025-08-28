package autotrader.core;

public interface UpdateHandler<U> {
    void handleUpdate(U update);
}
