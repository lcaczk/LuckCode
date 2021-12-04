package com.wkk.simulation.hw;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author weikunkun
 * @since 2021/9/1
 */
public class A {
    private static String EMPTY = "empty";
    private static String INS = "instanceOf";
    private static String SUB = "subClassOf";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> subMap = new HashMap<>(128);
        Map<String, List<String>> insMap = new HashMap<>(128);
        while (T-- > 0) {
            String[] line = sc.nextLine().split(" ");
            String ops = line[1];
            if (ops.equals(INS)) {
                String base = line[2];
                String ins = line[0];
                insMap.computeIfAbsent(base, list -> new ArrayList<>()).add(ins);
            } else if (ops.equals(SUB)) {
                String sup = line[2];
                String sub = line[0];
                subMap.computeIfAbsent(sup, list -> new ArrayList<>()).add(sub);
            }
        }
        String target = sc.nextLine();
        cal(subMap, insMap, target);
    }

    private static void cal(Map<String, List<String>> subMap, Map<String, List<String>> insMap, String target) {
        if (!insMap.containsKey(target) && !subMap.containsKey(target)) {
            System.out.println(EMPTY);
        }
        Set<String> list = new TreeSet<>((x, y)-> (x.compareTo(y)));
        // 已知结果
        List<String> res = insMap.getOrDefault(target, new ArrayList<>());
        list.addAll(res);
        // 对应的子类
        List<String> subList = subMap.getOrDefault(target, new ArrayList<>());
        for (String str : subList) {
            if (insMap.containsKey(str)) {
                list.addAll(insMap.get(str));
            }
        }
        for (String str : list) {
            System.out.print(str + " ");
        }
    }
}
