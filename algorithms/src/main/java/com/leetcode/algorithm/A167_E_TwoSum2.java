package com.leetcode.algorithm;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.The function twoSum should return indices of the two numbers such that they add up to the
 * target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Created by yujianmei on 2017-09-18
 */
public class A167_E_TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0, len = numbers.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                } else if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return null;
    }

    public int[] twoSumV2(int[] numbers, int target) {
        int[] result = new int[2];
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            if (numbers[low] + numbers[high] == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                return result;
            } else if (numbers[low] + numbers[high] > target) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }
}
