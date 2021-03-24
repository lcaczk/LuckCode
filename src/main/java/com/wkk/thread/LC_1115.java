package com.wkk.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115 交替打印foobar
 *
 * @author weikunkun
 * @since 2021/3/24
 */
public class LC_1115 {
    private int n;
    private volatile boolean flag = true;
    private Object lock = new Object();


    public LC_1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (lock) {
                while (!flag) {
                    lock.wait();
                }
                printFoo.run();
                flag = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (lock) {
                while (flag) {
                    lock.wait();
                }
                printBar.run();
                flag = true;
                lock.notifyAll();
            }
        }
    }

}

// 大练兵

/**
 * 1. 信号量
 * acquire - 1
 * release + 1
 */
class FoobarSemaphore {
    private int n;

    public FoobarSemaphore(int n) {
        this.n = n;
    }

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    public void foo(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            runnable.run();
            bar.release();
        }
    }

    public void bar(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            runnable.run();
            foo.release();
        }
    }
}

/**
 * 2. 公平锁
 */
class FoobarFairLock {
    private int n;

    public FoobarFairLock(int n) {
        this.n = n;
    }

    Lock lock = new ReentrantLock(true);
    volatile boolean permitFoo = true;

    public void foo(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (permitFoo) {
                    runnable.run();
                    i++;
                    permitFoo = false;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!permitFoo) {
                    runnable.run();
                    i++;
                    permitFoo = false;
                }

            } finally {
                lock.unlock();
            }
        }
    }
}

/**
 * 3. 无锁
 */
class FoobarUnlock {
    private int n;
    private volatile boolean foo = true;

    public FoobarUnlock(int n) {
        this.n = n;
    }

    public void foo(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (foo) {
                runnable.run();
                i++;
                foo = false;
            }
        }
    }

    public void bar(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (!foo) {
                runnable.run();
                i++;
                foo = true;
            }
        }
    }
}

/**
 * 4. CyclicBarrier
 */
class FoobarCyclicBarrier {
    int n;

    public FoobarCyclicBarrier(int n) {
        this.n = n;
    }

    CyclicBarrier cb = new CyclicBarrier(2);
    volatile boolean foo = true;

    public void foo(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!foo) {
            }
            runnable.run();
            foo = false;
            try {
                cb.await();
            } catch (BrokenBarrierException e) {

            }
        }
    }

    public void bar(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (BrokenBarrierException e) {

            }
            runnable.run();
            foo = true;
        }
    }

}