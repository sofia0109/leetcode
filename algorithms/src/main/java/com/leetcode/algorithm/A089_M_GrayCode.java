package com.leetcode.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * <p>
 * Created by yujianmei on $date
 */
public class A089_M_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            int v = i ^ i >> 1;
            result.add(v);
        }
        return result;
    }

    public static void main(String[] args) {
        new A089_M_GrayCode().grayCode(2);
    }
}
