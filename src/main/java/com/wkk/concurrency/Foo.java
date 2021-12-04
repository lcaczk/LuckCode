package com.wkk.concurrency;

/**
 * @author weikunkun
 * @since 2021/6/6
 */
public class Foo {
    private volatile int count = 0;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(this) {
            while(count % 3 != 0) {
                wait();
            }
            count++;
            notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(this) {
            while(count % 3 != 1) {
                wait();
            }
            count++;
            notifyAll();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(this) {
            while(count % 3 != 2) {
                wait();
            }
            count++;
            notifyAll();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
