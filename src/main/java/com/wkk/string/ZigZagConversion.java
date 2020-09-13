package com.wkk.string;

import com.wkk.everyday.aug.SmallestRangeCoveringElementsfromKLists;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目： Z字行变换
 * <p>
 * 描述：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 示例：
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 思路：
 * 可以将整个变形的存储结构视为一个二维数组，
 * @author kongwiki@163.com
 * @since 2020/9/11 11:07 上午
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i  = 0;
        int flag = -1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            list.get(i).append(c);
            if(i == 0 || i == numRows-1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int numRows = 1;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }
}
