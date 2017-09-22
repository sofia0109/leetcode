package com.leetcode.algorithm;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is
 * equal to the product of all the elements of nums except nums[i].

   Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Created by yujianmei on 2017-09-12
 */
public class A238_M_ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        // Notice: why cur = 1? because a * b = a * 1 * b. (a means the left part, b means the right part, 1 means itself)
        int cur = 1;
        leftToRight[0] = 1;
        for (int i = 1; i < len; i++) {
            leftToRight[i] = cur * nums[i - 1];
            cur = leftToRight[i];
        }

        rightToLeft[len - 1] = 1;
        cur = 1;
        for (int i = len - 2; i >= 0; i--) {
            rightToLeft[i] = nums[i + 1] * cur;
            cur = rightToLeft[i];
        }

        for (int i = 0; i < len; i++) {
            result[i] = leftToRight[i] * rightToLeft[i];
        }
        return result;
    }
}
