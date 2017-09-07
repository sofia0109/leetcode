package com.leetcode.algorithm;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Created by yujianmei on 2017-09-07
 */
public class A098_M_ValidateBinarySearchTree {

    /**
     * pay attention to the boundary.
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        //return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); wrong version
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     *
     * Pay attention to the boundary.
     *
     * if the max is Integer.MAX_VALUE, this method will failed when node.value = Integer.MAX_VALUE or Integer.MIN_VALUE
     *
     * @param node
     * @param min
     * @param max
     * @return
     */
    //private boolean validBST(TreeNode node, int min, int max) { wrong version
    private boolean validBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val >= min || node.val <= max) return false;
        return validBST(node.left, min, node.val)
                && validBST(node.right, node.val, max);
    }
}
