package com.wkk.simulation.mt;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/6/30
 */
public class 六位数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        System.out.println(cal(str));
    }

    private static int cal(String[] arr) {
        int first = Integer.parseInt(arr[0]);
        int second = Integer.parseInt(arr[1]);
        int count = 0;
        for (int i = first; i <= second; i++) {
            if (isOk(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isOk(int num) {
        String str = String.valueOf(num);
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        Integer first = Integer.parseInt(str.substring(0, 2));
        Integer second = Integer.parseInt(str.substring(2, 4));
        Integer third = Integer.parseInt(str.substring(4, 6));
        if (first + second == third) {
            return true;
        }
        return false;
    }
}
