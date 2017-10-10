package com.leetcode.algorithm;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Created by yujianmei on 2017-10-10
 */
public class A023_H_MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }
        ListNode fake = new ListNode(Integer.MAX_VALUE), tail = fake;
        while (!queue.isEmpty()) {
            ListNode first = queue.poll();
            if (first != null) {
                tail.next = first;
                tail = first;
                if (first.next != null) {
                    queue.add(first.next);
                }
            }
        }
        return fake.next;
    }

    public static void main(String[] args) {

    }
}
