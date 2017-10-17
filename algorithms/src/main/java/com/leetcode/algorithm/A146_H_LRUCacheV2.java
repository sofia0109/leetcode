package com.leetcode.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its CAPACITY, it should invalidate
 * the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Created by yujianmei on 2017-10-16
 */
public class A146_H_LRUCacheV2 {
    private final int CAPACITY;
    private LinkedHashMap<Integer, Integer> map;

    public A146_H_LRUCacheV2(int capacity) {
        this.CAPACITY = capacity;
         map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
             protected boolean removeEldestEntry(Map.Entry eldest) {
                 return size() > capacity;
             }
         };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
}
