package com.wkk.string;

/**
 * 对于罗马数字从左到右的每一位，选择尽可能大的符号值
 * @Time: 20-4-8上午9:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strings ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]){
                sb.append(strings[i]);
                num -= nums[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a = 90;
        System.out.println(intToRoman(a));
    }
}
