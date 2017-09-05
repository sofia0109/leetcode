package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * <p>
 * Created by yujianmei on 2017/09/01.
 */
public class A015_E_3Sum {
    /**
     * Notice:
     *
     * The most complex part is : How to avoid duplicate array?
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0, end = nums.length - 3; i <= end; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    int total = nums[low] + nums[high] + nums[i];
                    if (total == 0) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (total > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        new A015_E_3Sum().threeSum(nums);
    }
}
