package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Created by yujianmei on 2017-10-14
 */
public class A239_H_SlideWindowMaximum {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i > (k - 2)) {
                result[index++] = queue.peek();
                queue.remove(nums[i - k + 1]);
            }
        }
        return result;
    }
}
