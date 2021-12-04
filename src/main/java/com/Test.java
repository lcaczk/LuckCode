package com;

/**
 * @author weikunkun
 * @since 2021/5/9
 */
public class Test {
    private static int sum;
    public static void addSum(int num) {
        sum += num;
    }

    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>(7);
//        int n = 10;
//        n >>>= 1;
//        System.out.println(n);
//        for (int i = 0; i <= 10000; i++)  {
//            new Thread(()-> addSum(1)).start();
//        }
//
//        System.out.println(sum);
        int sum = 24;
        int total = 0;
        for (int i = 25; i <= 45; i++) {
            total += sum * i;
            sum += 1;
        }
        System.out.println(total);
    }
}
