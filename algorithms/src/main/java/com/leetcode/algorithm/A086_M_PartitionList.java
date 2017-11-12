package com.leetcode.algorithm;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Created by yujianmei on 2017-11-09
 */
public class A086_M_PartitionList {
    public ListNode partition(ListNode head, int x) {
       if (head == null) return null;
       ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
       fakeHead.next = head;
       ListNode cur = head, pre = fakeHead;
       while (cur != null && cur.val < x) {
           pre = cur;
           cur = cur.next;
       }

       //all node is less than x.
       if (cur == null) {
           return head;
       }

        ListNode pre1 = cur, cur1 = cur.next;
        while (true) {
           while (cur1 != null && cur1.val >= x) {
               pre1 = cur1;
               cur1 = cur1.next;
           }
           if (cur1 == null) break;
           //delete cur node
           int v = cur1.val;
           pre1.next = cur1.next;

           //insert node
           ListNode deleted = new ListNode(v);
           pre.next = deleted;
           deleted.next = cur;

           //reset data structure
           pre = deleted;
           cur1 = cur1.next;
       }
       return fakeHead.next;
    }

    public static void main(String[] args) {

    }
}
