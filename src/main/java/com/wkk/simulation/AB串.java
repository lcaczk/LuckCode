package com.wkk.simulation;

import java.util.Objects;

/**
 * 题目描述：
 * 小明得到一个只包含a,b两个字符的字符串，但是小明不希望在这个字符串里a出现在b左边。现在他可以将”ab”这样的子串替换成”bba”，在原串中的相对位置不变。输出小明最少需要操作多少次才能让一个给定字符串所有a都在b的右边。
 * 输入描述
 * 一个只包含a,b字符的字符串，长度不超过100000。
 * 输出描述
 * 最小的操作次数。结果对1000000007取模。
 * 样例输入
 * ab
 * 样例输出
 * 1
 * 提示
 * 样例1解释：ab到bba
 * 样例2：
 * 输入：aab
 * 输出：3
 * 样例2解释：aab到abba到bbaba到bbbbaa
 * @author weikunkun
 * @since 2021/4/17
 */
public class AB串 {
    /**
     * 思路
     * 从右往左
     * 以 ababb为例子
     *    a     b     a     b    b     b
     * 1⃣              ▶ （a 后面有三个b）
     *    a     b     b  b  a     b     b
     *    a     b     b  b  b  b  a     b
     *    a     b     b  b  b  b  b  b  a    进行了三次操作，正好就是a后序的三个b
     * 2⃣  ▶  （后续有 1（前一个a和当前a之间b的个数） + 6（前一个a变换后b的个数）个b）
     *
     * 3⃣  依次类推
     * 总结：
     * 1. 仅包含一个a的字符串，则a后续的b的个数就是需要变换的次数
     * 2. 遇到第二个a时，需要改变的次数是第一次遇到a和第二次遇到a之间b的个数+第一次遇到a时b的数个*2
     ** 依次类推
     * @param str
     * @return
     */
    public static int countOperations(String str) {
        if (Objects.isNull(str)) {
            return -1;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int res = 0;
        int b = 0;
        for (int i = len - 1; i >= 0; i--) {
            // 未遇到a时，统计b的次数
            if (chars[i] == 'b') {
                b += 1;
            } else if (chars[i] == 'a') {
                res =  (res + b) % 1000000007;
                // b的数量变为原先的两倍
                b = (b * 2) % 1000000007;
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(countOperations(""));
    }
}
