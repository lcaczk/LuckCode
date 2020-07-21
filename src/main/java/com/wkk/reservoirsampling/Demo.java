package com.wkk.reservoirsampling;

import com.wkk.utils.SortUtils;

import java.util.Random;

/**
 * @Time: 2020/7/21上午10:00
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Demo {
    private  int[] nums;
    private  int n;
    private  Random random = new Random();

    public Demo(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
    }

    public  int[] sampling(int k) {
        int[] sample = new int[k];
        // 将前k个元素存入蓄水池中
        for (int i = 0; i < k; i++) {
            sample[i] = nums[i];
        }
        for (int i = k; i < n; i++) {
            // 0 - i 的一个整数
            int x = random.nextInt(i + 1);
            if (x < k) {
                sample[x] = nums[x];
            }
        }
        return sample;
    }

    public static void main(String[] args) {
//        int[] ints = SortUtils.generateRandomArray(100, 100);
//        Demo demo = new Demo(ints);
//        for (int i : demo.sampling(20)) {
//            System.out.println(i);
//        }

    }
}
