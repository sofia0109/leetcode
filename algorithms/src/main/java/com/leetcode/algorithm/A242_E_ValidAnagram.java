package com.leetcode.algorithm;

import java.util.Objects;

/**
 * Hello world!
 * <p>
 * Created by yujianmei on 2017-09-10
 */
public class A242_E_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (Objects.equals(s, t)) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        int[] left = new int[26];
        int[] right = new int[26];
        for (char c : s.toCharArray()) {
            left[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            right[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (left[i] != right[i]) return false;
        }
        return true;
    }
}
