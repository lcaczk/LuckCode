package com.wkk.simulation.tx;

import java.util.Collections;

/**
 * @author weikunkun
 * @since 2021/7/2
 */
public class 压缩算法 {
    public static String compress (String str) {
        // write code here
        return decode(str);
    }
    public static String decode(String words){
        while (words.contains("]")){
            int right = words.indexOf("]");
            int left = words.lastIndexOf("[", right);
            String repeatStr = words.substring(left+1, right);
            String[] split = repeatStr.split("\\|");
            words = words.replace("["+repeatStr+"]",
                    String.join("", Collections.nCopies(Integer.parseInt(split[0]), split[1])));
        }
        return words;
    }

    public static void main(String[] args) {
        compress("HG[3|B[2|CA]]F");
    }
}
