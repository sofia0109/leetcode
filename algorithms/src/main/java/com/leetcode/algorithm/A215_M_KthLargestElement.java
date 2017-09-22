package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Created by yujianmei on 2017-09-21
 */
public class A215_M_KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * get this idea from quick sort.
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestV2(int[] nums, int k) {
        shuffle(nums);
        int len = nums.length;
        int low = 0, high = len - 1;
        int kth = len - k;
        //Notice: low must less than high, not less or equal.
        while (low < high) {
            int pivot = partition(nums, low, high);
            if (pivot == kth) {
                return nums[pivot];
            } else if (pivot > kth) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return nums[kth];
    }

    private int partition(int[] nums, int low, int high) {
        assert low < high;
        int v = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (nums[++i] < v) {
                if (i == high) break;
            }
            while (nums[--j] > v);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private void shuffle(int[] nums) {
        Random r = new Random();
        int len = nums.length;
        for (int i = len; i > 0; i--) {
            int a = r.nextInt(i);
            swap(nums, a, i - 1);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
