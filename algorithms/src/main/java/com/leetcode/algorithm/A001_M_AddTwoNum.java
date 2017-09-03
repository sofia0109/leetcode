package com.leetcode.algorithm;

/**
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
 *
 * Created by yujianmei on 2017/8/31.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class A001_M_AddTwoNum {
    /**
     *
     *
     * Note: pay attention when inc is not 0 after the loop.
     *
     * Bad case: (5) (5) (0 -> 1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode tail = head;
        int inc = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                inc += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                inc += l2.val;
                l2 = l2.next;
            }
            ListNode cur = new ListNode(inc % 10);
            tail.next = cur;
            tail = cur;
            inc = inc / 10;
        }
        if (inc > 0) {
            tail.next = new ListNode(inc);
        }
        return head.next;
    }
    public static void main(String[] args) {

    }
}
