package com.leetcode.algorithm;
/**
 * Hello world!
 *
 * Created by yujianmei on 2017-11-12
 */
public class A222_M_CountCompleteTreeNode {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root, right = root;
        int leftHeight = 0, rightHeight = 0;
        while (left != null) {
            leftHeight++;
            left = left.left;
        }

        while (right != null) {
            rightHeight++;
            right = right.right;
        }

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        //NOte: () is necessary
        System.out.println(1 << 2 - 1);
        System.out.println((1 << 2) - 1);
    }
}
