package autotrader.binance;

import autotrader.binance.model.exchange.symbol.Symbol;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ScalperState {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private Symbol symbol;

    public Symbol getSymbol() {
        lock.readLock().lock();
        try {
            return symbol;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setSymbol(Symbol symbol) {
        lock.writeLock().lock();
        try {
            this.symbol = symbol;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
