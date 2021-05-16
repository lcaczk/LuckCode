package com.wkk.weekcompete;

/**
 * 5743. 增长的内存泄露
 * @author weikunkun
 * @since 2021/5/16
 */
public class MemLeak {
    public static int[] memLeak(int memory1, int memory2) {
        //
        if (memory1 < 1 && memory2 < 1) {
            return new int[] {1, memory1, memory2};
        }
        int count = 0;
        while (true) {
            count++;
            // 如何避免频繁的交换
            int flag = 1;
            int temp = memory1;
            if (memory1 < memory2) {
                flag = 2;
                temp = memory2;
            }
            if (temp - count < 0) {
                if (flag == 2) {
                    return new int[] {count, memory1, temp};
                } else {
                    return new int[] {count, temp, memory2};
                }
            }
            temp -= count;
            if (flag == 2) {
                memory2 = temp;
            } else {
                memory1 = temp;
            }
        }
    }

    public static void main(String[] args) {
        int m1 = 9;
        int m2 = 6;
        memLeak(m1,m2);
    }
}
