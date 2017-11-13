package com.leetcode.algorithm;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 *
 *  reated by yujianmei on 2017-11-13
 */
public class A654_M_MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int max = maxIndex(nums, low, high);
        TreeNode root = new TreeNode(nums[max]);
        root.left = build(nums, low, max - 1);
        root.right = build(nums, max + 1, high);
        return root;
    }

    private int maxIndex(int[] nums, int begin, int end) {
        int max = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] > nums[max]) max = i;
        }
        return max;
    }

    public static void main( String[] args ) {
    }
}
