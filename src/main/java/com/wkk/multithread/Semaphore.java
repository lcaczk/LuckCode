package com.wkk.multithread;

/**
 * @Time: 2020/7/16下午9:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Semaphore {
    private static volatile int sempahore = 0;

    static class A implements Runnable{

        @Override
        public void run() {
            while (sempahore < 10){
                if(sempahore % 2 == 0){
                    System.out.println("A "+ sempahore);
                    sempahore+=1;
                }
            }
        }
    }

    static class B implements Runnable{

        @Override
        public void run() {
            while (sempahore < 10 ) {
                if(sempahore % 2 == 1) {
                    System.out.println("B:" + sempahore);
                    sempahore++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new A()).start();
        new Thread(new B()).start();

    }
}
