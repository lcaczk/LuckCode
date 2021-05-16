package com.wkk.weekcompete;

/**
 * 构成交替字符串需要的最小交换次数
 *
 * @author weikunkun
 * @since 2021/5/16
 */
public class LC_5760 {
    public static int minSwaps(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        char[] chs = s.toCharArray();
        char[] standard1 = genArray(len, '1');
        char[] standard2 = genArray(len, '0');
        int[] onChanges = genChange(chs, standard1);
        int[] zeroChanges = genChange(chs, standard2);
        // 都不相同 -1
        if ((onChanges[0] == onChanges[1]) || (zeroChanges[0] == zeroChanges[1])) {
            if ((onChanges[0] == onChanges[1]) && (zeroChanges[0] == zeroChanges[1])) {
                return  Math.min(onChanges[0], zeroChanges[0]);
            }
            return onChanges[0] != onChanges[1] ? zeroChanges[0] : onChanges[0];
        }
        return -1;
    }

    private static int[] genChange(char[] chs, char[] standard) {
        int toZeroCount = 0;
        int toOneCount = 0;
        int len = chs.length;
        for (int i = 0; i < len; i++) {
            if (chs[i] != standard[i]) {
                if (chs[i] == '1') {
                    toZeroCount += 1;
                } else {
                    toOneCount += 1;
                }
            }
        }
        return new int[]{toOneCount, toZeroCount};
    }

    private static char[] genArray(int len, char first) {
        char[] array = new char[len];
        if (first == '1') {
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    array[i] = '1';
                } else {
                    array[i] = '0';
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    array[i] = '0';
                } else {
                    array[i] = '1';
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("100"));
    }

}
