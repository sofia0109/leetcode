package com.leetcode.algorithm;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Could you do it in O(n) time and O(1) space
 * Created by yujianmei on 2017-09-11
 */
public class A234_E_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        ListNode left = head, right = slow;
        while (right != null) {
            if (right.val != left.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head.next, pre = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }


}
