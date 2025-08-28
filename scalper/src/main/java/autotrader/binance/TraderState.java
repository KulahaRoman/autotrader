package autotrader.binance;

import autotrader.binance.model.Balance;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TraderState {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private Trade trade;
    private Phase phase;
    private Context context;

    private Balance baseAssetBalance;
    private Balance quoteAssetBalance;

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

    public Trade getTrade() {
        lock.readLock().lock();
        try {
            return trade;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setTrade(Trade trade) {
        lock.writeLock().lock();
        try {
            this.trade = trade;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Phase getPhase() {
        lock.readLock().lock();
        try {
            return phase;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setPhase(Phase phase) {
        lock.writeLock().lock();
        try {
            this.phase = phase;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Context getContext() {
        lock.readLock().lock();
        try {
            return context;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setContext(Context context) {
        lock.writeLock().lock();
        try {
            this.context = context;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
