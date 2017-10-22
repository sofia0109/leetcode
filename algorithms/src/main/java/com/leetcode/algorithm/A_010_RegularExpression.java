package com.leetcode.algorithm;
/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * Created by yujianmei on 2017-10-21
 */
public class A_010_RegularExpression {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sLen = s.length();
        int patternLen = p.length();
        boolean[][] result = new boolean[sLen + 1][patternLen + 1];
        result[0][0] = true;
        //if pattern is empty, the s must be empty. so result[i][0] = false. (i between 1 and sLen)
        for (int i = 2; i <= patternLen; i++) {
            result[0][i] = (p.charAt(i - 1) == '*' && result[0][i - 2]);
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= patternLen; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))
                    result[i][j] = result[i - 1][j - 1];
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        // * match multiple character
                        result[i][j] = result[i - 1][j] || result[i][j - 2];
                    } else {
                        // * match 0 character
                        result[i][j] = result[i][j - 2];
                    }
                }
            }
        }
        return result[sLen][patternLen];
    }

    private boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static void main(String[] args) {

    }
}
