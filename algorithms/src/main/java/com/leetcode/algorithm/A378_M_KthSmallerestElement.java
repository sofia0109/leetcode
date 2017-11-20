package com.leetcode.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Created by yujianmei on 2017-11-14
 */
public class A378_M_KthSmallerestElement {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int[] ints : matrix) {
            for (int i : ints) {
                queue.add(i);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

    //created on 2017-11-19
    public int kthSmallestV2(int[][] matrix, int k) {
        int len = matrix.length;
        int low = matrix[0][0], high = matrix[len - 1][matrix[0].length - 1];
        while (low < high) {
            int smallerCnt = 0, mid = (low + high) / 2;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (matrix[i][j] <= mid) {
                        smallerCnt++;
                    } else {
                        break;
                    }
                }
            }
            if (smallerCnt < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
