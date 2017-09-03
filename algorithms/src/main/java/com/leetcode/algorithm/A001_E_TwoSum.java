package com.leetcode.algorithm;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * Created by yujianmei on 2017/8/31.
 */
public class A001_E_TwoSum {
    /**
     * complexity: n2
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV1(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) {
            throw new NullPointerException("nums failed.");
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }


    /**
     *
     * Complexity: n
     *
     * Note: left part : line 63: i != j
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV2(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) {
            throw new NullPointerException("nums failed.");
        }
        HashMap<Integer, Integer> numIndex = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0, len = nums.length; i < len; i++) {
            numIndex.put(nums[i], i);
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            int left = nums[i];
            int right = target - left;
            Integer j = numIndex.get(right);
            if (j != null && i != j) {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
