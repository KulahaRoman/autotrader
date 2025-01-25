package autotrader.binance;

import autotrader.binance.model.Balance;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@NoArgsConstructor
@AllArgsConstructor
public class TraderState {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private Balance baseAssetBalance;
    private Balance quoteAssetBalance;
    private Trade activeTrade;

    public Balance getBaseAssetBalance() {
        lock.readLock().lock();
        try {
            return baseAssetBalance;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setBaseAssetBalance(Balance baseAssetBalance) {
        lock.writeLock().lock();
        try {
            this.baseAssetBalance = baseAssetBalance;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Balance getQuoteAssetBalance() {
        lock.readLock().lock();
        try {
            return quoteAssetBalance;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setQuoteAssetBalance(Balance quoteAssetBalance) {
        lock.writeLock().lock();
        try {
            this.quoteAssetBalance = quoteAssetBalance;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Trade getActiveTrade() {
        lock.readLock().lock();
        try {
            return activeTrade;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setActiveTrade(Trade activeTrade) {
        lock.writeLock().lock();
        try {
            this.activeTrade = activeTrade;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean hasActiveTrade() {
        lock.readLock().lock();
        try {
            return activeTrade != null;
        } finally {
            lock.readLock().unlock();
        }
    }
}
