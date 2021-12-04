package com.wkk.interview.bytedance2020;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Time: 2020/7/25上午9:58
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_LRUCache {
    private final LRU<Integer, Integer> lru;

    public Medium_LRUCache(int capacity) {
        lru = new LRU<Integer, Integer>(capacity);
    }

    public int get(int key) {
        return lru.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        lru.put(key, value);
    }

    class LRU<K, V> extends LinkedHashMap<K, V> {
        private int capacity;

        public LRU(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }


        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > capacity;
        }


    }
}
