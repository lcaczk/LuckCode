package com.wkk.simulation.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/15
 */
public class 两种排序方法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        cal(arr);
    }

    private static void cal(String[] arr) {
        boolean dict = isDictOrder(arr);
        boolean len = isLenOrder(arr);
        if (!dict && !len) {
            System.out.println("none");
            return;
        }
        if (dict && len) {
            System.out.println("both");
            return;
        } else  {
            if (dict) {
                System.out.println("lexicographically");
            } else {
                System.out.println("lengths");
            }
        }
    }

    private static boolean isDictOrder(String[] arr) {
        int n = arr.length;
        String[] tmp = Arrays.copyOf(arr, n);
        Arrays.sort(tmp, (x,y)->(x.compareTo(y)));
        for (int i = 0; i < n; i++) {
            if (tmp[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLenOrder(String[] arr) {
        int n = arr.length;
        String[] tmp = Arrays.copyOf(arr, n);
        Arrays.sort(tmp, (x,y)->(x.length() - y.length()));
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                return false;
            }
        }
        return true;
    }
}
