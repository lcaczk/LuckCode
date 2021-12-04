package com.wkk.bitoperation;

/**
 * @author weikunkun
 * @since 2021/10/2
 */
public class LC_405 {
    public String toHex(int num) {
        // 思路
        // 不停的求余
        // 然后添加求余的数字
        if (num == 0) {
            return "0";
        }
        boolean isNeg = num < 0;
        StringBuilder sb = new StringBuilder();
        num = Math.abs(num);
        while (num != 0) {
            int cur = num % 16;
            num /= 16;
            sb.append(numToChar(cur));
        }
        if (isNeg) {
            sb.append("-");
        }
        return sb.reverse().toString();

    }

    private char numToChar(int num) {
        if (num >= 10) {
            return (char) (num - 10 +  'a');
        }
        return (char) (num + '0');
    }
}
