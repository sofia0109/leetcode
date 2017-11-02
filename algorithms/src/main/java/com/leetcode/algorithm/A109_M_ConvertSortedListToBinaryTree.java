package com.leetcode.algorithm;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * Created by yujianmei on 2017-11-02
 */
public class A109_M_ConvertSortedListToBinaryTree {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre == null) {
            return head == null ? null : new TreeNode(head.val);
        }

        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
