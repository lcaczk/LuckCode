package com.offer;

/**
 * 题目：剑指 Offer 19.正则表达式匹配
 * 题目链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * 标签：动态规划
 * <p>
 * 题目描述：
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * <p>
 * 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
 */
class Offer19 {
    /**
     * 递归
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        // 字符串长度为0，检测正则串
        if (m == 0) {
            // 正则串长度为奇数必定不匹配，比如 "."、"ab*",必须是 a*b*这种形式，*在奇数位上
            if (n % 2 != 0) {
                return false;
            }
            for (int j = 1; j <= n; j += 2) {
                if (p.charAt(j) != '*') {
                    return false;
                }
            }
            return true;
        }
        // 字符串长度不为0，正则长度为0，返回false
        if (n == 0) {
            return false;
        }
        char nowS = s.charAt(0);
        char nowP = p.charAt(0);
        char nextP = 'a';
        if (n > 1) {
            nextP = p.charAt(1);
        }
        // 判断'*'
        if (nextP != '*') {
            // 如果该位字符一样，或正则串该位是 '.',也就是能匹配任意字符，就可以往后走
            if (nowS == nowP || nowP == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else {
            // 如果该位字符一样，或是正则串该位是 '.'，有看和不看两种情况
            if (nowS == nowP || nowP == '.') {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                // 不一样，那么正则串跳过这两位
                return isMatch(s, p.substring(2));
            }
        }
    }


    /**
     * 动态规划
     */
    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // s和p都为空
        dp[0][0] = true;
        // 第一行初始化（s为空，p不为空）
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char nowS = s.charAt(i - 1);
                char nowP = p.charAt(j - 1);
                // s[i-1]==p[j-1]相等，或者p[j-1]=='.'，判断前面一部分就行
                if (nowS == nowP || nowP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (nowP == '*') {
                        if (j >= 2) {
                            // 只有p[j-2]==s[i-1]或p[j-2]==‘.’才可以让*取1个或者多个字符：
                            if (p.charAt(j - 2) == nowS || p.charAt(j - 2) == '.') {
                                dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                            }
                            // 不论p[j-2]是否等于s[i-1]都可以删除掉j-1和j-2处字符：
                            dp[i][j] = dp[i][j] || dp[i][j - 2];

                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        Offer19 solution = new Offer19();
        System.out.println("===true:");
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("aa*", "a**"));
        System.out.println("===false:");
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }
}