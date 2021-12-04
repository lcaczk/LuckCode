package com.wkk.simulation.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/5/30
 */
public class LC_5772 {
    private Map<Character, Integer> map;
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        this.map = genHashMap();
        char[] first = firstWord.toCharArray();
        char[] second = secondWord.toCharArray();
        char[] target = targetWord.toCharArray();
        int fNum = genNum(first);
        int sNum = genNum(second);
        int tNum = genNum(target);
        return fNum + sNum == tNum;

    }

    private int genNum(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(map.get(ch));
        }
        return Integer.parseInt(sb.toString());
    }

    private Map<Character, Integer> genHashMap() {
        Map<Character, Integer> map = new HashMap<>();
        String s = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = s.toCharArray();
        int num = 0;
        for (char aChar : chars) {
            map.put(aChar, num++);
        }
        return map;
    }

    public static void main(String[] args) {
    }
}
