package com.jee.integration;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Иван on 04.03.2017.
 */
public class ThreadLocalTest {
    private static final int OBSERVER_SLEEP_TIMEOUT = 100;
    private static final long ITERATION_COUNT_PEER_THREAD = 100000;
    private static final int THREAD_COUNT = 10;
    private static final long INCREMENT_COUNT = 10;

    @Test
    public void doWork() throws Exception {
        ThreadLocalCounter counter = new ThreadLocalCounter();
        CounterThread[] threads = new CounterThread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }

        int aliveThreadCount = THREAD_COUNT;

        while (aliveThreadCount > 0) {
            Thread.sleep(OBSERVER_SLEEP_TIMEOUT);
            aliveThreadCount = 0;

            for (CounterThread thread : threads) {
                if (thread.isAlive()) {
                    aliveThreadCount++;
                }
            }
        }

        long sum = counter.getSum();
        Assert.assertTrue(sum == ITERATION_COUNT_PEER_THREAD * THREAD_COUNT * INCREMENT_COUNT);
    }

    private class CounterThread extends Thread {
        private ThreadLocalCounter counter;

        public CounterThread(ThreadLocalCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (long i = 0; i < ITERATION_COUNT_PEER_THREAD; i++) {
                counter.add(INCREMENT_COUNT);
            }
        }
    }

    private class ThreadLocalCounter {
        private ThreadLocal<SumContainer> scope = new ThreadLocal<>();
        private final List<SumContainer> data = new ArrayList<>();
        private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        public void add(long value) {
            SumContainer container = scope.get();
            if (container == null) {
                container = new SumContainer();
                scope.set(container);
                readWriteLock.writeLock().lock();
                try {
                    data.add(container);
                } finally {
                    readWriteLock.writeLock().unlock();
                }
            }
            container.value += value;
        }

        public long getSum() {
            long sum = 0l;

            readWriteLock.readLock().lock();
            try {
                for (SumContainer container : data) {
                    sum += container.value;
                }
                return sum;
            } finally {
                readWriteLock.readLock().unlock();
            }
        }
    }

    private static class SumContainer {
        public long value;
    }
}
