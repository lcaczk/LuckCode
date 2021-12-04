package com.wkk.simulation.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * dfs
 *
 * @author weikunkun
 * @since 2021/6/1
 */
public class 幸运的袋子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = scanner.nextInt();
            Arrays.sort(nums);
            System.out.println(find(nums, 0, 0, 1));
        }
    }

    private static int find(int[] nums, int index, long sum, long multi) {
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            multi *= nums[i];
            if (sum > multi)
                count += 1 + find(nums, i + 1, sum, multi);
            else if (nums[i] == 1)
                count += find(nums, i + 1, sum, multi);
            else
                break;
            sum -= nums[i];
            multi /= nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return count;
    }
}
