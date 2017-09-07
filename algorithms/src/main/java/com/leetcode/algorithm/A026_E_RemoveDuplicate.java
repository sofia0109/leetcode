package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * Hello world!
 * <p>
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * <p>
 * Created by yujianmei on 2017-09-07
 */
public class A026_E_RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int total = 0, cur = 0, len = nums.length;
        while (cur < len) {
            while (cur < len - 1 && nums[cur] == nums[cur + 1]) {
                cur++;
            }
            nums[total] = nums[cur];
            total++;
            cur++;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr1 = {1};
        int num = new A026_E_RemoveDuplicate().removeDuplicates(arr1);
        System.out.println("num= " + num + " array= " + Arrays.toString(arr1));
    }
}
