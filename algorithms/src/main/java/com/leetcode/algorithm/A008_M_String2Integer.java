package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Created by yujianmei on 2017/09/03.
 */
public class A008_M_String2Integer {
    /**
     *
     * This algorithm is not difficult, but I have to
     * handle many spacial case.
     *
     * eg: 1. +-12 return 0
     *     2. -0012a42 return -12
     *     3. overflow
     *     4. space character
     *     5. + or - at the beginning of string
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // remove space at the beginning
        int i = 0;
        while (Character.isSpaceChar(str.charAt(i))) {
            i++;
        }
        //remove space at the end
        int j = str.length() - 1;
        while (Character.isSpaceChar(str.charAt(j))) {
            j--;
        }
        //positive or negative
        boolean positive = true;
        if (str.charAt(i) == '-') {
            positive = false;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        //in case of overflow
        double result = 0;
        boolean first = true;
        while (i <= j) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result = result * 10 + (str.charAt(i) - '0');
            } else {
                if (first) {
                    return 0;
                } else {
                    break;
                }
            }
            first = false;
            i++;
        }
        if (!positive) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int result = new A008_M_String2Integer().myAtoi("    010");
        int result2 = new A008_M_String2Integer().myAtoi("-0012a42");
        System.out.println(result);
        System.out.println(result2);
    }
}
