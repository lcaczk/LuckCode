package com.wkk.simulation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class 缓存设计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        LRU<Integer, Integer> lru = new LRU<>(capacity);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] strs = line.split(" ");
            if (strs[0].equals("p")) {
                int key = Integer.parseInt(strs[1]);
                int value = Integer.parseInt(strs[2]);
                lru.put(key, value);
            } else {
                int key = Integer.parseInt(strs[1]);
                int value = lru.getOrDefault(key, -1);
                System.out.println(value);
            }
        }

    }

    public static class LRU<K,V> extends LinkedHashMap<K, V> {
        private int capacity;
        public LRU(int capacity) {
            super(capacity, 0.75F, true); // 访问顺序
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > capacity;
        }
    }
}
