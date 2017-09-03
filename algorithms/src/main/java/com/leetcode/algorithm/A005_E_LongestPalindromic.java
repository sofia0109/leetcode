package com.leetcode.algorithm;

import java.util.Stack;

/**
 * Longest Palindromic Substring
 * <p>
 * <p>
 * Created by yujianmei on 2017/09/01.
 */
public class A005_E_LongestPalindromic {
    /**
     * The basic idea is using DP
      p[i][i] == true
      if (j - i < 2) {
           p[i][j] = true only when charAt(i) == charAt(j)
      }  else  {
           p[i][j] = true only when charAt(i) == charAt(j) && p[i+1][j-1] = true
      }
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] p = new boolean[len][len];
        int maxLen = 0, start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                p[i][j] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || p[i - 1][j + 1]));
                if (p[i][j] && (i - j + 1) > maxLen) {
                    maxLen = i - j + 1;
                    start = j;
                    end = i;
                }
            }
            p[i][i] = true;
        }
        return s.substring(start, end  + 1);
    }

    public static void main(String[] args) {
    }
}
