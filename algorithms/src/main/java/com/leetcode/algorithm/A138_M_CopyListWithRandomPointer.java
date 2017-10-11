package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.Return a deep copy of the list.
 * <p>
 * Created by yujianmei on 2017-10-11
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {
        this.label = x;
    }
}

public class A138_M_CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> m = new HashMap<>();
        RandomListNode cur = head, fake = new RandomListNode(0), tail = fake;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            tail.next = node;
            m.put(cur, node);
            tail = node;
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode randomNode = cur.random;
            if (randomNode != null) {
                RandomListNode curCopy = m.get(cur);
                curCopy.random = m.get(randomNode);
            }
            cur = cur.next;
        }
        return fake.next;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
