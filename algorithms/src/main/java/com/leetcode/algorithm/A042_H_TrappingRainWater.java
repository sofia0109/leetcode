package com.leetcode.algorithm;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * Created by yujianmei on 2017-10-10
 */
public class A042_H_TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] leftMax = new int[len];
        leftMax[0] = 0;
        int[] rightMax = new int[len];
        rightMax[len - 1] = 0;
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int totalWater = 0;
        for (int i = 0; i < len; i++) {
            int h = Math.min(leftMax[i], rightMax[i]) - height[i];
            //Notice: h must larger than 0
            if (h > 0) {
                totalWater += h;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }
}
