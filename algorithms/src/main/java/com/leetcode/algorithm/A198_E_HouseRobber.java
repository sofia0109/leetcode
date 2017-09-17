package com.leetcode.algorithm;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p>
 * Created by yujianmei on 2017-09-17
 */
public class A198_E_HouseRobber {
    /**
     * if robber current house
     * rob[i - 2] + nums[i]
     * if not robber current house
     * rob[i - 1]
     * ==
     * Math.max(rob[i - 2] + nums[i], rob[i - 1])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int prevRob = 0, prevNotRob = 0;
        for (int num : nums) {
            int curRob = prevNotRob + num;
            prevNotRob = Math.max(prevNotRob, prevRob);
            prevRob = curRob;
        }
        return Math.max(prevRob, prevNotRob);
    }
}
