package com.wkk.interview.bytedance2021.design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146 LRU缓存机制
 * @author weikunkun
 * @since 2021/3/13
 */
public class LRUCache {
    private LRU<Integer, Integer> lru;

    public LRUCache(int capacity) {
        lru = new LRU<>(capacity);
    }

    public int get(int key) {
        return lru.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        lru.put(key, value);
    }

    private class LRU<K, V> extends LinkedHashMap<K, V> {
        int capacity;

        public LRU(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return this.size() > capacity;
        }
    }
}
