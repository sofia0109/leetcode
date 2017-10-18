package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate
 * the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Created by yujianmei on 2017-10-18
 */
class DoubleListNode {
    public int k;
    public int v;
    public DoubleListNode pre;
    public DoubleListNode next;

    public DoubleListNode(int k, int v) {
        this.k = k;
        this.v = v;
    }

    public DoubleListNode() {
    }
}

public class A146_H_LRUCache {
    private int size;
    private int capacity;
    private DoubleListNode head;
    private DoubleListNode tail;
    Map<Integer, DoubleListNode> m = new HashMap<>();

    public A146_H_LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DoubleListNode();
        this.tail = new DoubleListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleListNode node = m.get(key);
        if (node != null) {
            int v = node.v;
            //delete the current node
            deleteNode(node);
            //move the current node to tail
            moveToHead(node);
            return v;
        }
        return -1;
    }

    private void moveToHead(DoubleListNode node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }

    private void deleteNode(DoubleListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        DoubleListNode node = m.get(key);
        if (node != null) {
            node.v = value;
            deleteNode(node);
            moveToHead(node);
        } else {
            node = new DoubleListNode(key, value);
            m.put(key, node);
            size++;
            moveToHead(node);
            if (size > capacity) {
                deleteLast();
                size--;
            }
        }
    }

    private void deleteLast() {
        DoubleListNode last = tail.pre;
        m.remove(last.k);
        deleteNode(last);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
