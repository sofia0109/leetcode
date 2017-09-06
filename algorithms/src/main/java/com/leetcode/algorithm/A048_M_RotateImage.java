package com.leetcode.algorithm;

/**
 *  You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).
 *
 * Created by yujianmei on 2017-09-06
 */
public class A048_M_RotateImage
{
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        int mid = len / 2;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < mid; j++) {
                 int temp = matrix[i][len - 1 - j];
                 matrix[i][len - 1 - j] = matrix[i][j];
                 matrix[i][j] = temp;
            }
        }
    }

    public static void main( String[] args )
    {
        boolean[][] matrix = new boolean[4][5];
        System.out.println(matrix[0].length);
    }
}
