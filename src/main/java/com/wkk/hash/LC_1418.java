package com.wkk.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/7/6
 */
public class LC_1418 {
    public static List<List<String>> displayTable(List<List<String>> orders) {
        // 不难，但是绕， 模拟
        Set<String> set = new HashSet<>();
        Set<String> numsSet = new HashSet<>();
        Map<String, Map<String, Integer>> foodMap = new HashMap<>();
        // 统计
        for (List<String> tmp : orders) {
            String id = tmp.get(1);
            String food = tmp.get(2);
            set.add(food);
            Map<String, Integer> innerMap = foodMap.getOrDefault(id, new HashMap<>());
            innerMap.put(food, innerMap.getOrDefault(food, 0) + 1);
            foodMap.put(id, innerMap);
            numsSet.add(id);
        }
        List<String> foodsList = new ArrayList<>(set);
        Collections.sort(foodsList);
        // 行结束
        foodsList.add(0, "Table");
        // 列
        List<String> numsList = new ArrayList<>(numsSet);
        Collections.sort(numsList, (x, y) -> (Integer.valueOf(x) - Integer.valueOf(y)));
        // 构造
        List<List<String>> res = new ArrayList<>();
        res.add(foodsList);
        List<String> inner;
        for (String idx : numsList) {
            inner = new ArrayList<>();
            inner.add(idx);
            for (int i = 1; i < foodsList.size(); i++) {
                int curNum = foodMap.get(idx).getOrDefault(foodsList.get(i), 0);
                inner.add(String.valueOf(curNum));
            }
            res.add(inner);
        }
        return res;
    }

    public static void main(String[] args) {
        String[][] res = {{"David", "3", "Ceviche"}, {"Corina", "10", "Beef Burrito"}, {"David", "3", "Fried Chicken"},
                {"Carla", "5", "Water"}, {"Carla", "5", "Ceviche"}, {"Rous", "3", "Ceviche"}};
        List<List<String>> list = new ArrayList<>();
        for (String[] re : res) {
            list.add(Arrays.asList(re));
        }
        displayTable(list);
    }
}
