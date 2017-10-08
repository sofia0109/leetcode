package com.leetcode.algorithm;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * <p>
 * Created by yujianmei on 2017-09-30
 */
public class A240_M_Search2D {
    public static void main(String[] args) {
        int[][] matrix = new int[5][7];
        System.out.println(matrix.length == 5);
        System.out.println(matrix[0].length == 7);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int col = matrix[0].length - 1, row = 0;
        while (col >= 0 && row < matrix.length) {
            int pivot = matrix[row][col];
            if (target == pivot) {
                return true;
            } else if (target > pivot) {
                row++;
            } else if (target < pivot) {
                col--;
            }
        }
        return false;
    }
}
