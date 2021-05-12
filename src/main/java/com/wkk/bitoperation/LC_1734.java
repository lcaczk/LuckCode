package com.wkk.bitoperation;

/**
 * 1734. 解码异或后的排列
 * 由1720转变而来
 * 思路： 先想办法套出原数组的第一个元素
 *       之后使用1720的办法解决即可
 * @author weikunkun
 * @since 2021/5/11
 */
public class LC_1734 {
    public static int[] decode(int[] encoded) {
        // e[i-1] = p[i-1] ^ p[i]
        // p[i-1] ^ e[i-1] = p[i] 核心
        // ans全部异或 abcde
        // encoded[] = [ab, bc, cd, de]
        // abcde ^ bcde = a
        // ok
        int len = encoded.length;
        int[] ans = new int[len + 1];
        int rst = 0;
        for (int i = 1; i <= len + 1; i++) {
            rst ^= i;
        }
        //rst = abced
        int temp = 0;
        for (int i = 1; i < len; i += 2) {
            temp ^= encoded[i];
        }
        int first = temp ^ rst;
        ans[0] = first;
        for (int i = 1; i <= len; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] en = {3, 1};
        System.out.println(decode(en));
    }

}
