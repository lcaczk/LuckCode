package com.wkk.simulation.zj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class 用户喜好 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            // key : value
            // value : list (idx)
            int key = sc.nextInt();
            map.getOrDefault(key, new ArrayList<>()).add(i + 1);
        }
        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> list = map.getOrDefault(k, null);
            System.out.println(cal(list, l, r));
        }
    }

    private static int cal(List<Integer> list, int left, int right) {
        if (null == list || list.size() == 0) {
            return 0;
        }
        // 找到第一个 小于等于 l的位置
        // 之后统计 [l, r] 区间中list元素的数量
        int n = list.size();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (list.get(mid) < left) {
                i = mid  + 1;
            } else {
                j = mid;
            }
        }
        int count = 0;
        while (i < n) {
            if (list.get(i)>= left && list.get(i) <= right) {
                count++;
            }
            if (list.get(i) > right) {
                break;
            }
            i++;
        }
        return count;
    }
}
