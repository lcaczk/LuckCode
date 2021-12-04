package com.wkk;

import java.nio.charset.Charset;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class B {
    public static void main(String[] args) {
        String binary = "0111001001101100";
        System.out.println(toString(binary));
        System.out.println((int)'码');
        System.out.println(Charset.defaultCharset());
        System.out.println(Integer.toBinaryString(228));
        System.out.println(Integer.toBinaryString(19990));
        System.out.println(Integer.toBinaryString(30721));
    }

    public static String toString(String binary) {
        String[] tempStr=binary.split(" ");
        char[] tempChar=new char[tempStr.length];
        for(int i=0;i<tempStr.length;i++) {
            tempChar[i]=BinstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }


    //将二进制字符串转换成int数组
    public static int[] BinstrToIntArray(String binStr) {
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length];
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }


    //将二进制转换成字符
    public static char BinstrToChar(String binStr){
        int[] temp=BinstrToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }
        return (char)sum;
    }
}
