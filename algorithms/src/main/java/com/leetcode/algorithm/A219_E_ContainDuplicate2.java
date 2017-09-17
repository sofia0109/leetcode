package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the
 * array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Created by yujianmei on 2017-09-17
 */
public class A219_E_ContainDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> valueIndex = new HashMap<>(nums.length);
        for (int i = 0, len = nums.length; i < len; i++) {
            int v = nums[i];
            if (valueIndex.containsKey(v)) {
                if (i - valueIndex.get(v) <= k) {
                    return true;
                }
            }
            //Notice: update index every time
            valueIndex.put(v, i);
        }
        return false;
    }
}
