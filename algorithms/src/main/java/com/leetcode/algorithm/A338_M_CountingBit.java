package com.leetcode.algorithm;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Created by yujianmei on 2017-11-12
 */
public class A338_M_CountingBit {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (1 & i);
        }
        return dp;
    }
}
