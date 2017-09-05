package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 * <p>
 * aaaadefg
 * <p>
 * <p>
 * Created by yujianmei on 2017/09/01.
 */
public class A003_M_LongestSubString {

    /**
     *
     * Complexity : n2
     *
     * this version is just workable, but far from efficient and elegant.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 1;
        Set<Character> cur = new HashSet<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            for (int j = i; j < len; j++) {
                if (cur.contains(s.charAt(j))) {
                    if (cur.size() > max) {
                        max = cur.size();
                        cur.clear();
                    }
                    break;
                } else {
                    cur.add(s.charAt(j));
                }
            }
        }
        return max > cur.size() ? max : cur.size();
    }

    /**
     *
     * Basic idea behind this version:
     *
     * left : the index of no duplicate array
     * res  : length of longest non replicate array
     * i :    the index of current non replicate array
     * Every time we meet a duplicate array, update the left index.
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV2(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }

    public static void main(String[] args) {
        new A003_M_LongestSubString().lengthOfLongestSubstringV2("abcdefgh");
        new A003_M_LongestSubString().lengthOfLongestSubstringV2("bbb");
    }
}
