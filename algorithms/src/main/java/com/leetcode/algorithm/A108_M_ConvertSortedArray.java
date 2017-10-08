package com.leetcode.algorithm;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * Created by yujianmei on 2017-09-30
 */
public class A108_M_ConvertSortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, low, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, high);
        return node;
    }
}
