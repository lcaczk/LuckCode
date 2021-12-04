package com.wkk.string;

import java.util.Scanner;

/**
 * 字符串的统计字符串
 * 正反互换都要会
 * https://www.nowcoder.com/practice/e8b97a6d64ae4304b6f0ff4ecae1589d?tpId=101&&tqId=33166&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 * @author weikunkun
 * @since 2021/6/19
 */
public class CD_98 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(cal(str));
    }

    private static String cal(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int j = 0;
        while (i < n) {
            if (arr[i] == arr[j]) {
                i++;
            } else {
                int dis = i - j;
                sb.append(arr[j]);
                sb.append("_");
                sb.append(dis);
                sb.append("_");
                j = i;
                i++;
            }
        }
        int dis = i - j;
        sb.append(arr[j]);
        sb.append("_");
        sb.append(dis);
        return sb.toString();
    }
}
