package com.wkk.simulation.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/6/6
 */
public class LC_5777 {
    public static int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        int[] arr = new int[nums.length];
        int k = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[k++] = nums[i];
        }
        for (int num : arr) {
            map.put(num,map.getOrDefault(num, 0) +1);
        }
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer num : map.keySet()) {
            if (num == min) {
                continue;
            }
            sum += map.get(num);
            list.add(sum);
        }
        return list.stream().mapToInt(i->i).sum();

    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3};
        System.out.println(reductionOperations(arr));
    }
}
