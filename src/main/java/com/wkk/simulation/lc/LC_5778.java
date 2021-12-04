package com.wkk.simulation.lc;

/**
 * @author weikunkun
 * @since 2021/6/6
 */
public class LC_5778 {
    public int minFlips(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        String one = genStand(len, '1');
        String zero = genStand(len, '0');
        return  1;
    }

    public int minFlipsII(String s) {
        int odd = 0, even = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                even += s.charAt(i) - '0';
            } else {
                odd += s.charAt(i) - '0';
            }
        }
        int n = s.length();
        if (n % 2 == 0) {
            return Math.min((n / 2 - odd + even), (n / 2 - even + odd));
        }
        int res = Integer.MAX_VALUE;
        // 模拟执行 i 次类型 1 的操作
        for (int i = 0; i < s.length(); i++) {
            res = Math.min(res, Math.min(n / 2 - odd + even, n / 2 + 1 - even + odd));
            if (s.charAt(i) == '1') {
                odd++;
                even--;
            }
            int t = even;
            even = odd;
            odd = t;
        }
        return res;
    }

    private static String genStand(int len, char stater) {
        StringBuilder sb = new StringBuilder();
        char next = stater == '0' ? '1' : '0';
        int i = 0;
        while (i < len) {
            if (i % 2 == 0) {
                sb.append(stater);
            } else {
                sb.append(next);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(genStand(8, '0'));
        System.out.println(genStand(8, '1'));
    }
}
