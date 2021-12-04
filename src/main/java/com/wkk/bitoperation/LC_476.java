package com.wkk.bitoperation;

/**
 * @author weikunkun
 * @since 2021/10/18
 */
public class LC_476 {
    public static int findComplementII(int num) {
        // 思路
        // 位运算
        // num & (-num) 获取当前最高位的1
        // 1010 - > 1000
        int highBit = 1;
        int x = num;
        while (num != 0) {
            highBit = num & (-num);
            num &= num - 1;
        }
        return x ^ ((highBit << 1) - 1);

    }

    public static int findComplement(int num) {
        // 思路
        // 先求二进制 = a，然后取反 = b，最后获取 b 的十进制结果
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num >>= 1;
        }
        char[] charArray = sb.reverse().toString().toCharArray();
        sb = new StringBuilder();

        for (char ch : charArray) {
            if (ch == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(findComplementII(100));
//        int num = 100;
//        System.out.println(Integer.toBinaryString(num));
//        int highBit = num & (-num);
//        System.out.println(Integer.toBinaryString(highBit));
    }
}
