package com.wkk.weekcompete;

/**
 * @author weikunkun
 * @since 2021/4/11
 */
public class LC_5726 {
    private static int nagivate = 0;
    private static int flag = 0;
    public static int arraySign(int[] nums) {
        boolean a = help(nums);
        if (!a) {
            return 0;
        }
        if (nagivate % 2 == 1) {
            return -1;
        } else {
            return 1;
        }
    }

    private static boolean help(int[] nums) {
        for (int num : nums) {
            if (num < 0) {
                nagivate++;
            }else if (num > 0) {
                flag++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] temp = {41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41};
        int[] ano = {9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24};
        System.out.println(arraySign(ano));
    }
}
