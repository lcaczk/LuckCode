package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/4
 */
public class 小易喜欢的单词 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(judge(str));
    }

    private static String judge(String str) {
        char[] data=str.toCharArray();
        if(data[0]>'Z'){
            return "Dislikes";
        }
        for(int i=1;i<data.length;i++){
            if(data[i]>'Z'||data[i-1]==data[i]){
                return "Dislikes";
            }
        }
        return "Likes";
    }
}
