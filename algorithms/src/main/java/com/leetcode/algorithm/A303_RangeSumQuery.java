package com.leetcode.algorithm;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * created by yujianmei on 2017-10-30
 */
public class A303_RangeSumQuery {
    private int[] nums;
    private int[] sum;

    public A303_RangeSumQuery(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        init();
    }

    private void init() {
        if (nums.length == 0) return;
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if ((i < 0 || i >= nums.length) || (j < 0 || j <= nums.length)) {
            throw new IllegalArgumentException("i or j is invalid.");
        }
        return i == 0 ? sum[j] : (sum[j] - sum[i - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        A303_RangeSumQuery sumQuery = new A303_RangeSumQuery(nums);
        System.out.println(sumQuery.sumRange(0, 5));
    }
}
