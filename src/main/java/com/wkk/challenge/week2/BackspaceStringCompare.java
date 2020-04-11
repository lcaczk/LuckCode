package com.wkk.challenge.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-4-10上午8:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        List<Character> listS = genList(S);
        List<Character> listT = genList(T);
        if(listS.size() != listT.size()){
            return false;
        }
        for (int i = 0; i < listS.size(); i++) {
            if(!listS.get(i).equals(listT.get(i))){
                return false;
            }
        }
        return true;

    }

    private static List<Character> genList(String s){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#'){
               if(list.size() != 0){
                   list.remove(list.size()-1);
               }
            }else {
                list.add(s.charAt(i));
            }

        }
        return list;
    }

    public static void main(String[] args) {
        String s = "a##";
        String t = "a";
        System.out.println(backspaceCompare(s, t));
    }
}
