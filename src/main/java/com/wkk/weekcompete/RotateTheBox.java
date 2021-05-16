package com.wkk.weekcompete;

/**
 * 5744. 旋转盒子
 * 可参考图像的旋转
 *
 * @author weikunkun
 * @since 2021/5/16
 */
public class RotateTheBox {
    public static char[][] rotateTheBox(char[][] box) {
        change(box);
        return reverse(box);
    }

    /**
     * 遍历原矩阵的第一行，等于遍历新矩阵的倒数第一列
     *
     * @param box
     * @return
     */
    private static char[][] reverse(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] reverseBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reverseBox[j][m - i - 1] = box[i][j];
            }
        }
        return reverseBox;
    }

    /**
     * 循环每一行
     * 遇到障碍物，停止
     * 将石头移动到障碍物之前
     * 其余位置 置空
     * 继续
     *
     * @param box
     * @return
     */
    private static char[][] change(char[][] box) {
        for (int i = 0; i < box.length; i++) {
            change(box[i]);
        }
        return box;
    }

    /**
     * 从右往前移动，初始可放置位置 pos = len - 1
     * 遇到障碍物，pos --
     * 遇到石头， 将石头移动到 pos 位置 并将原石头位置只为空（如果移动后的位置和原石头位置不同）
     * @param rows
     */
    private static void change(char[] rows) {
        int len = rows.length;
        int pos = len - 1; // 可放置障碍物的地方
        for (int j = len - 1; j >= 0; j--) {
            if (rows[j] == '#') { // 石头
                rows[pos--] = '#';
                if (pos != j - 1) {
                    rows[j] = '.';
                }
            } else if (rows[j] == '*') { // 障碍物
                pos = j - 1;
            }
        }
    }

    public static void main(String[] args) {
        char[][] chars = {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
        char[][] chars1 = rotateTheBox(chars);
        for (char[] chars2 : chars1) {
            for (char c : chars2) {
                System.out.printf("%s\t", c);
            }
            System.out.println();
        }
    }
}
