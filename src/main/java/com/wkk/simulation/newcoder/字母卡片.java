package com.wkk.simulation.newcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/15
 */
public class 字母卡片 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (sc.hasNext()) {
            //获取输入数据
            String[] str0 = sc.nextLine().split(" ");
            int n = Integer.parseInt(str0[0]);
            int k = Integer.parseInt(str0[1]);
            String str = sc.nextLine();
            //处理输入数据->键值对
            int len = str.length();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < len ; i++) {
                char ch=str.charAt(i);
                if(map.containsKey(ch)) {
                    map.put(ch, map.get(ch)+1);
                }else {
                    map.put(ch, 1);
                }
            }
            //对值排序
            ArrayList<Integer> list = new ArrayList<Integer>(map.values());
            long grade = 0;
//			Collections.sort(list);
//			Collections.reverse(list);
            Collections.sort(list,new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    // TODO Auto-generated method stub
                    return o2-o1;
                }
            });
            //计算结果
            for (int i : list) {
                if (i >= k) {
                    grade += (long) k * k;
                    System.out.println(grade);
                    break;
                } else {
                    grade += (long) i * i;
                    k -= i;
                }
            }

        }
    }
}
