package com.leetcode.algorithm;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number
 * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Created by yujianmei on 2017-09-14
 */
public class A202_E_HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> before = new HashSet<>();
        while (!before.contains(n)) {
            before.add(n);
            n = digitSquareSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum = sum + digit * digit;
        }
        return sum;
    }
}
