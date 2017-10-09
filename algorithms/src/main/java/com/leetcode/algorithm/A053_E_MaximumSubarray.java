package com.leetcode.algorithm;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Created by yujianmei on 2017-10-08
 */
public class A053_E_MaximumSubarray {
    /**
     * the basic idea is use DP
     *
     * s[i] = max {s[i - 1} + nums[i], nums[i]};
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], curMax = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
