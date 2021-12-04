package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * 没看懂
 * @author weikunkun
 * @since 2021/6/7
 */
public class 附加题 {
    /**
     * 记录三种旋转需要变动的下标，共三组下标
     * 每组下标里，每4个下标形成一个轮回
     */
    private static int[][] map = new int[][]{
            {0,1,3,2,7,5,22,9,6,4,23,8},
            {6,7,13,12,2,8,17,11,3,14,16,5},
            {4,5,11,10,0,6,16,20,2,12,18,22}
    };

    /**
     * main
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 读取输入
        Scanner sc = new Scanner(System.in);
        int[] n = new int[24];
        for (int i = 0; i < 24; i++) {
            n[i] = sc.nextInt();
        }

        // 输出结果
        System.out.println(resolve(n, -1, 5));
    }

    /**
     * 分析当前状态
     * @param n 当前状态
     * @param type 达到当前状态时的最后一个操作类型
     * @param remain 剩余操作数
     * @return 可以达到的最大优美度
     */
    private static int resolve(int[] n, int type, int remain) {
        // 非法状态
        if (remain < 0) return Integer.MIN_VALUE;
        // 当前状态优美度
        int max = compute(n);
        // 尝试转动，不可与type类型相同
        if (type != 0) max = Math.max(max, turn(n, 0, remain));
        if (type != 1) max = Math.max(max, turn(n, 1, remain));
        if (type != 2) max = Math.max(max, turn(n, 2, remain));
        return max;
    }

    /**
     * 按照类型转动魔方多次并分析
     * @param n 当前状态
     * @param type 转动类型
     * @param remain 剩余操作数
     * @return 转动可以达到的最大优美度
     */
    private static int turn(int[] n, int type, int remain) {
        // 转动一次
        turn(n, type);
        int max = resolve(n, type, remain-1);
        // 转动两次
        turn(n, type);
        max = Math.max(max, resolve(n, type, remain-2));
        // 转动三次，相当于逆向转动一次
        turn(n, type);
        max = Math.max(max, resolve(n, type, remain-1));
        // 转动四次，还原初始状态
        turn(n, type);
        return max;
    }

    /**
     * 转动操作
     * @param n 当前状态
     * @param type 转动类型
     */
    private static void turn(int[] n, int type) {
        // 每四个下标一轮回
        for (int i = 0, tmp = 0; i < 12; i++) {
            if (i % 4 == 0) tmp = n[map[type][i]];
            if (i % 4 == 3) n[map[type][i]] = tmp;
            else n[map[type][i]] = n[map[type][i+1]];
        }
    }

    /**
     * 计算当前状态的优美度
     * @param n 当前状态
     * @return 优美度
     */
    private static int compute(int[] n) {
        return n[0]*n[1]*n[2]*n[3] +
                n[6]*n[7]*n[12]*n[13] +
                n[4]*n[5]*n[10]*n[11] +
                n[8]*n[9]*n[14]*n[15] +
                n[16]*n[17]*n[18]*n[19] +
                n[20]*n[21]*n[22]*n[23];
    }
}
