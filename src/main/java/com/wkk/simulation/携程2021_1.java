package com.wkk.simulation;

/**
 * 递归
 * @author weikunkun
 * @since 2021/4/15
 */
public class 携程2021_1 {
    private static final String R = "R";
    private static final String G = "G";

    public static String buildingHouse(String n) {
        int num = 0;
        try {
            num = Integer.parseInt(n);
        } catch (Exception e) {
            return "N";
        }
        if (num > 12 || num < 1) {
            return "O";
        }
        StringBuilder sb = new StringBuilder();
        int len = getSum(num) + 1;
        String[] array = new String[len];
        genArray(array, 0, array.length);
        for (String str : array) {
            System.out.println(str);
        }
        return "J";
    }

    private static int genArray(String[] array, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        array[mid] = R;
        int leftNum = genArray(array, left, mid - 1);
        int rightNum = genArray(array, mid + 1, right);
        array[leftNum] = G;
        array[rightNum] = R;
        return mid;
    }

    private static int getSum(int n) {
        int sum = 0;
        while (n > 1) {
            sum += (int) Math.pow(2, n - 1);
            n -= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        buildingHouse("3");
    }
}
