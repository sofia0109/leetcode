package com.leetcode.algorithm;

/**
 * Hello world!
 * <p>
 * Created by yujianmei on 2017-09-10
 */
public class A160_E_IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        //align
        int lenA = len(headA), lenB = len(headB);
        ListNode curA = headA, curB = headB;
        while (lenA > lenB) {
            curA = curA.next;
            lenA--;
        }
        while (lenA < lenB) {
            curB = curB.next;
            lenB--;
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
            if (curA == null || curB == null) break;
        }
        return curA;
    }

    private int len(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
