package com.wkk.easy;

/**
 * @Time: 20-3-16下午8:31
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if(judgePrime(i)){
                count++;
            }
        }
        return count;

    }
    public static boolean judgePrime(int n){
        if(n <=1){
            return false;
        }
        for (int i = 2; i*i < n; i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static int countPrimesII(int n){
        boolean[] prime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(!prime[i]){
                count++;
            }
            for (int j = 2; j*i < n; j++) {
                prime[i*j] = true;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        int i = countPrimesII(n);
        System.out.println(i);
    }
}
