package com.wkk.everyday.aug;

/**
 * @author kongwiki@163.com
 * @since 2020/8/16上午9:29
 */
public class FloodFill {
    // 回溯
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return new int[0][0];
        }
        int m = image.length;
        int n = image[0].length;
        int curColor = image[sr][sc];
        if(image[sr][sc]==newColor) {
            return image;
        }
        backtrack(image, m, n, sr, sc, curColor, newColor);
        return image;
    }

    private void backtrack(int[][] image, int m, int n, int x, int y, int curColor, int newColor) {
        if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != curColor) {
            return;
        }
        image[x][y] = newColor;
        backtrack(image, m, n, x + 1, y, curColor, newColor);
        backtrack(image, m, n, x - 1, y, curColor, newColor);
        backtrack(image, m, n, x, y + 1, curColor, newColor);
        backtrack(image, m, n, x, y - 1, curColor, newColor);

    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        FloodFill fill = new FloodFill();
        int[][] ints = fill.floodFill(a, 1, 1, 2);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
