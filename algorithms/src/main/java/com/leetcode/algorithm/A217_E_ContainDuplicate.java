package com.leetcode.algorithm;

import java.util.HashSet;

public class A217_E_ContainDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> checker = new HashSet<>();
        for (int num : nums) {
            if (checker.contains(num)) {
                return true;
            }
            checker.add(num);
        }
        return false;
    }
}
