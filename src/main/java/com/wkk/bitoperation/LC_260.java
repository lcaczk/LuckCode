package com.wkk.bitoperation;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author weikunkun
 * @since 2021/10/30
 */
public class LC_260 {
    public int[] singleNumber(int[] nums) {
        // 思路 位运算 异或操作
        int rst = Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        // 寻找第一个不为0的位置
        int operation = 1;
        while ((operation & rst) != 0) {
            operation <<= 1;
        }
        System.out.println(operation);
        AtomicInteger first = new AtomicInteger();
        AtomicInteger second = new AtomicInteger();
        int finalOperation = operation;
        Arrays.stream(nums).forEach(ele -> {
            if ((ele & finalOperation) == 0) {
                first.updateAndGet(v -> v ^ ele);
            } else {
                second.updateAndGet(v -> v ^ ele);
            }
        });
        return new int[]{first.intValue(), second.intValue()};
    }
}
