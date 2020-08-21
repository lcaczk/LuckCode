package com.wkk.multithread;

/**
 * @Time: 2020/7/16下午9:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WaitNotify {
    private static Object aaa;

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (aaa) {
                try {
                    for (int i = 0; i < 10; i++) {
                        if (i % 2 == 0) {
                            System.out.println("ThreadA: " + i);
                            aaa.notify();
                        } else {
                            aaa.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (aaa) {
                try {
                    for (int i = 0; i < 10; i++) {
                        if (i % 2 == 1) {
                            System.out.println("ThreadB: " + i);
                            aaa.notify();
                        } else {
                            aaa.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
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




