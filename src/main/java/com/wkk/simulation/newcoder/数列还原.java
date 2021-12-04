package com.wkk.simulation.newcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/5/30
 */
public class 数列还原 {
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            ArrayList<Integer> index = new ArrayList<>(); //数组中0的位置信息
            ArrayList<Integer> loss = new ArrayList<>();// 缺失的数字集合
            HashSet<Integer> set = new HashSet<>(); // 用set的contain方法快一点
            for (int i = 0; i < n; i++) {
                set.add(nums[i]);
                if (nums[i] == 0) {
                    index.add(i);
                    continue;
                }
                //减掉数组本身的正序数
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] > nums[i] & nums[i] != 0) k--;
                }
            }

            for (int i = 1; i <= n; i++) {
                if (!set.contains(i)) {
                    loss.add(i);
                }
            }
            backTracking(nums, index, loss, k, 0);
            System.out.println(result);
        }
        sc.close();

    }

    //回溯的模板
    public static void backTracking(int[] nums, ArrayList<Integer> index, ArrayList<Integer> loss, int k, int d) {
        if (k == 0 && loss.size() == 0) {
            result++;
            return;
        }
        if (k < 0 || d >= index.size()) return;
        int cur = index.get(d);
        for (int i = 0; i < loss.size(); i++) {
            int tmp = loss.remove(i);
            nums[cur] = tmp;
            backTracking(nums, index, loss, k - count(nums, cur), d + 1);
            nums[cur] = 0;
            loss.add(i, tmp);
        }

    }

    //插入一个数之后新增的正序数
    public static int count(int[] nums, int pos) {
        int ans = 0;
        for (int i = 0; i < pos; i++) {
            if (nums[i] > 0 && nums[i] < nums[pos]) ans++;
        }
        for (int i = pos + 1; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > nums[pos]) ans++;
        }
        return ans;
    }
}
