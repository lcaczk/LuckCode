package com.wkk.everyday.may;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Time: 2020/6/25上午10:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LRUCache{
    private final LRU<Integer, Integer> lru;

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
        // 保存缓存的容量
        private int capacity;

        public LRU(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        /**
         * 重写removeEldestEntry()方法设置何时移除旧元素
         *
         * @param eldest
         * @return boolean
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > this.capacity;
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

}
