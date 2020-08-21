package com.wkk.top.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kongwiki@163.com
 * @since 2020/8/10上午10:13
 */
public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>(16);
        char[] chs = s.toCharArray();
        for(char ch : chs){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((o1, o2) -> {
            //按照出现次数高到低，出现次数相同相等按字符
            if(o1.getValue().equals(o2.getValue())){
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            q.offer(entry);
        }


        StringBuilder stringBuilder = new StringBuilder();
        while(!q.isEmpty()){
            final Map.Entry<Character, Integer> item = q.poll();
            for (int i = 0; i < item.getValue(); i++) {
                stringBuilder.append(item.getKey());
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        String s = "afdsaacd";
        String b = "cccaaa";
        String c = "tee";
        String s1 = frequencySort(c);
        System.out.println(s1);
    }
}
