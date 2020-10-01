package com.wkk.everyday.oct;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目: 宝石与石头
 * 题目链接: https://leetcode-cn.com/problems/jewels-and-stones/
 * <p>
 * 给定字符串J代表石头中宝石的类型，和字符串 S代表你拥有的石头。
 * S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * <p>
 * 思路: map+两次遍历(最直白的思路)
 *
 * @author kongwiki@163.com
 * @since 2020/10/2
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            map.put(J.charAt(i), map.getOrDefault(J.charAt(i), 0) + 1);
        }
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                res++;
            }
        }
        return res;
    }
}
