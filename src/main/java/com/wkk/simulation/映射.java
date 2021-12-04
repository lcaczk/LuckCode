package com.wkk.simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/11
 */
public class 映射 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String oldStr = "1-a";
        String newStr = "1-a,2-b";
        String[] oldSplit = oldStr.split(",");
        String[] newSplit = newStr.split(",");
        Map<String, String> mapOld = genMap(oldSplit);
        Map<String, String> mapNew = genMap(newSplit);
        cal(mapOld, mapNew);
    }

    private static void cal(Map<String, String> mapOld,  Map<String, String> mapNew) {
//        1、id相同且字符串相同的两个词组视为相同
//        2、id相同，且字符串不同的输出modify+id
//        3、新的词组id在老的词组id中不存在的，视为新增，输出add+id
//        4、老的词组id在新的词组id中不存在的，视为删除，输出delete+id
        PriorityQueue<String> queue = new PriorityQueue<>((x,y)->(y.compareTo(x)));
        for (String s : mapOld.keySet()) {
            if (!mapNew.containsKey(s)) {
                queue.add("delete-" + s);
            } else {
                String oldV = mapOld.get(s);
                String newV = mapNew.get(s);
                if (!oldV.equals(newV)) {
                    queue.add("modify-" + s);
                }
            }
        }

        for (String s : mapNew.keySet()) {
            if (!mapOld.containsKey(s)) {
                queue.add("add-" + s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static Map<String, String> genMap(String[] arr) {
        Map<String, String> map = new HashMap<>();
        for (String s : arr) {
            String[] split = s.split("-");
            map.put(split[0], split[1]);
        }
        return map;
    }
}
