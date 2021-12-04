package com.wkk.simulation.mt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/30
 */
public class 小美的新游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        char[][] chars = new char[n][m];
        int curi = 0, curj = 0;
        for (int i = 0; i < n; i++) {
            chars[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (chars[i][j] == 'S') {
                    curi = i;
                    curj = j;
                }
            }
        }

        String str = sc.nextLine();
        Map<Character, int[]> map = new HashMap<>();
        map.put('W', new int[]{-1, 0});
        map.put('A', new int[]{0, -1});
        map.put('S', new int[]{1, 0});
        map.put('D', new int[]{0, 1});
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int ni = curi + map.get(str.charAt(i))[0];
            int nj = curj + map.get(str.charAt(i))[1];
            if (ni >= n || ni < 0 || nj >= m || nj < 0 || chars[ni][nj] == '#') {
                ni = curi;
                nj = curj;
            }
            if (chars[ni][nj] == 'O') {
                res += p;
                chars[ni][nj] = '+';
            }
            if (chars[ni][nj] == 'X') {
                res -= q;
                chars[ni][nj] = '+';
            }
            curi = ni;
            curj = nj;
        }
        System.out.println(res);
    }
}
