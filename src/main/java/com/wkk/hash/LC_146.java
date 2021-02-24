package com.wkk.hash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 缓存机制
 *
 * @author weikunkun
 * @since 2021/2/24
 */
public class LC_146 {
    private LRU<Integer, Integer> lru;

    public LC_146(int capacity) {
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
