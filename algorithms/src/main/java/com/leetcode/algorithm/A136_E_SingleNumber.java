package com.leetcode.algorithm;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
   Note:
   Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
   Created by yujianmei on 2017-09-30
 *
 */
public class A136_E_SingleNumber {
    /**
     * a ^ a = 0;
     * 0 ^ a = ~a;
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
