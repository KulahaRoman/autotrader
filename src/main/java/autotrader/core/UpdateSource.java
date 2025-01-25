package autotrader.core;

public interface UpdateSource<U> extends AutoCloseable {
    U nextUpdate() throws Exception;
}
