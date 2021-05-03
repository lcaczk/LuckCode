package com.wkk.recursive.base;

/**
 * @author weikunkun
 * @since 2021/5/1
 */
public class ReverseString {
    //    仔细观察问题所带来的约束，如果我们把它放到递归的环境中，我们可以把它解释为在两个连续的递归调用之间没有额外的空间消耗，也就是说，我们应该把问题划分为独立的子问题。
//
//    因此，关于如何划分问题的一个想法是将每个步骤中的输入字符串减少为两个组件：1).前导字符和末尾字符。2).没有前导字符和末尾字符的其余子字符串。 然后我们可以独立地解决这两个部分。
//
//    根据上述思想，我们可以提出如下算法:
//
//    从输入字符串中获取前导字符和尾随字符，即str[0] and str[n-1]
//    就地交换前导字符和末尾字符
//    递归调用函数来反转剩余的字符串，也就是reverseString(str[1...n-2])
    public void reverseString(char[] s) {
        // 递归
        if (s == null || s.length == 0) {
            return;
        }
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int left, int right) {
        if (left > right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s, ++left, --right);
    }
}
