package com.wkk.simulation.mt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/29
 */
public class 小美的书架 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] arrs1 = s1.split(" ");
        int n = Integer.parseInt(arrs1[0]);//书架
        int m = Integer.parseInt(arrs1[1]);//书本
        int q = Integer.parseInt(arrs1[2]);
        boolean[] lock = new boolean[10000];//这个长度不能为n
        Map<Integer, Integer> map = new HashMap<>();//小美的key-value=书编号-书架号
        Map<Integer, Integer> borrow = new HashMap<>();//小团借的书
        for (int i = 0; i < q; i++) {
            String s2 = sc.nextLine();
            String[] arrs2 = s2.split(" ");
            int one = Integer.parseInt(arrs2[0]);
            int x = Integer.parseInt(arrs2[1]) - 1;
            if (one == 1) {
                int y = Integer.parseInt(arrs2[2]) - 1;
                if (borrow.containsKey(x) || lock[y] || (map.containsKey(x) && lock[map.get(x)])) {
                } else map.put(x, y);
            } else if (one == 2) {
                lock[x] = true;
            } else if (one == 3) {
                lock[x] = false;
            } else if (one == 4) {
                if (map.containsKey(x) && !lock[map.get(x)]) {
                    System.out.println(map.get(x) + 1);
                    borrow.put(x, map.get(x));
                    map.remove(x);
                } else System.out.println(-1);
            } else {
                if (borrow.containsKey(x)) {
                    borrow.remove(x);
                }
            }
        }
    }
}
