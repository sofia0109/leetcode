package com.leetcode.algorithm;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i]
 * and nums[j] is at most t and the absolute difference between i and j is at most k.
 * <p>
 * Created by yujianmei on 2017-10-07
 */
public class A220_M_ContainDuplicateV3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        long start = System.currentTimeMillis();
        if (nums == null || nums.length == 0) {
            return false;
        }

        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < Math.min(len, i + k + 1); j++) {
                //Notice 1: pay attention to boundary. Math.abs(Integer.MIN_VALUE) return itself, it's negative.
                long abs = Math.abs((long)nums[i] - (long)nums[j]);
                System.out.println(System.currentTimeMillis() - start);
                if (abs <= t) return true;
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        return false;
    }

    public boolean containsNearbyAlmostDuplicateV2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long min = set.ceiling((long)nums[i] - t);    // minimum candicate in the target range [nums[i] - t, nums[i] + t]
            if (min != null && min <= (long)nums[i] + t) return true;    // found duplicates
            set.add((long)nums[i]);
            if (i >= k) set.remove((long)nums[i - k]);
        }
        return false;
    }
}
