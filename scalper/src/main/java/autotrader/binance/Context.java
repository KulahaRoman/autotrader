package autotrader.binance;

import autotrader.binance.model.Order;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@ToString
@NoArgsConstructor
public class Context {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private Order buyOrder;
    private Order trailingOrder;
    private Order sellOrder;

    private CompletableFuture<Void> balanceFuture;

    private CompletableFuture<Void> buyFuture;
    private CompletableFuture<Void> trailingFuture;
    private CompletableFuture<Void> sellFuture;

    private CompletableFuture<Void> enterTradeFuture;
    private CompletableFuture<Void> exitTradeFuture;

    public void setBuyOrder(Order buyOrder) {
        lock.writeLock().lock();
        try {
            this.buyOrder = buyOrder;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setTrailingOrder(Order trailingOrder) {
        lock.writeLock().lock();
        try {
            this.trailingOrder = trailingOrder;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setSellOrder(Order sellOrder) {
        lock.writeLock().lock();
        try {
            this.sellOrder = sellOrder;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setBalanceFuture(CompletableFuture<Void> balanceFuture) {
        lock.writeLock().lock();
        try {
            this.balanceFuture = balanceFuture;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setBuyFuture(CompletableFuture<Void> buyFuture) {
        lock.writeLock().lock();
        try {
            this.buyFuture = buyFuture;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setTrailingFuture(CompletableFuture<Void> trailingFuture) {
        lock.writeLock().lock();
        try {
            this.trailingFuture = trailingFuture;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setSellFuture(CompletableFuture<Void> sellFuture) {
        lock.writeLock().lock();
        try {
            this.sellFuture = sellFuture;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setEnterTradeFuture(CompletableFuture<Void> enterTradeFuture) {
        lock.writeLock().lock();
        try {
            this.enterTradeFuture = enterTradeFuture;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setExitTradeFuture(CompletableFuture<Void> exitTradeFuture) {
        lock.writeLock().lock();
        try {
            this.exitTradeFuture = exitTradeFuture;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Order getBuyOrder() {
        lock.readLock().lock();
        try {
            return buyOrder;
        } finally {
            lock.readLock().unlock();
        }
    }

    public Order getTrailingOrder() {
        lock.readLock().lock();
        try {
            return trailingOrder;
        } finally {
            lock.readLock().unlock();
        }
    }

    public Order getSellOrder() {
        lock.readLock().lock();
        try {
            return sellOrder;
        } finally {
            lock.readLock().unlock();
        }
    }

    public CompletableFuture<Void> getBalanceFuture() {
        lock.readLock().lock();
        try {
            return balanceFuture;
        } finally {
            lock.readLock().unlock();
        }
    }

    public CompletableFuture<Void> getBuyFuture() {
        lock.readLock().lock();
        try {
            return buyFuture;
        } finally {
            lock.readLock().unlock();
        }
    }

    public CompletableFuture<Void> getTrailingFuture() {
        lock.readLock().lock();
        try {
            return trailingFuture;
        } finally {
            lock.readLock().unlock();
        }
    }

    public CompletableFuture<Void> getSellFuture() {
        lock.readLock().lock();
        try {
            return sellFuture;
        } finally {
            lock.readLock().unlock();
        }
    }

    public CompletableFuture<Void> getEnterTradeFuture() {
        lock.readLock().lock();
        try {
            return enterTradeFuture;
        } finally {
            lock.readLock().unlock();
        }
    }

    public CompletableFuture<Void> getExitTradeFuture() {
        lock.readLock().lock();
        try {
            return exitTradeFuture;
        } finally {
            lock.readLock().unlock();
        }
    }
}