package com.wkk.simulation.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/5/30
 */
public class LC_5773 {
    public static String maxValue(String n, int x) {
        String substring = n.substring(0, 1);
        char[] array = n.toCharArray();
        boolean flag = !substring.equals("-");
        if (flag) {
            return genZhengNextNum(array, x);
        }
        return genFuNextNum(array, x);

    }

    private static String genZhengNextNum(char[] array, int x) {
        int N = array.length;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(array[i] - '0');
        }
        int idx = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (x > nums.get(i)) {
                idx = i;
                break;
            }
        }
        idx = idx == -1 ? nums.size() : idx;
        nums.add(idx, x);
        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static String genFuNextNum(char[] array, int x) {
        // 额外处理
        int N = array.length;
        char[] chars = new char[N - 1];
        System.arraycopy(array,1, chars, 0,N-1);
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N -1; i++) {
            nums.add(chars[i] - '0');
        }
        int idx = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (x < nums.get(i)) {
                idx = i;
                break;
            }
        }
        idx = idx == -1 ? nums.size(): idx;
        nums.add(idx, x);
        StringBuilder sb = new StringBuilder();
        sb.append("-");
        for (Integer num : nums) {
            sb.append(num);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(maxValue("3433672517219996", 1));
    }
}
