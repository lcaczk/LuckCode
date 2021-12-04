package com.wkk.math;

/**
 * @author weikunkun
 * @since 2021/11/24
 */
public class LC_423 {
    public String originalDigits(String s) {
        // zero -> z
        // one ----> n - 7 - 9 * 2
        // two -> w
        // three --> h - 8
        // four -> u
        // five --> f - 4
        // six -> x
        // seven --> s - 6
        // eight -> g
        // nine ---> i - 8 - 6 - 5
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int[] out = new int[10];
        out[0] = arr['z' - 'a'];
        out[2] = arr['w' - 'a'];
        out[4] = arr['u' - 'a'];
        out[6] = arr['x' - 'a'];
        out[8] = arr['g' - 'a'];
        out[1] = arr['o' - 'a'] - out[0] - out[2] - out[4];
        out[3] = arr['h' - 'a'] - out[8];
        out[5] = arr['f' - 'a'] - out[4];
        out[7] = arr['s'-  'a'] - out[6];
        out[9] = arr['i' - 'a'] - out[8] - out[6] - out[5];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (out[i] > 0) {
                sb.append(i);
                out[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC_423 lc_423 = new LC_423();
        System.out.println(lc_423.originalDigits("ofur"));
    }
}
