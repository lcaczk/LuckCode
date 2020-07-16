package com.wkk.multithread;

/**
 * @Time: 2020/7/16下午8:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PrintEvenOld {
    static class ThreadA implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("ThreadA: " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("ThreadB: " + i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();

    }
}
