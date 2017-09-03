package com.leetcode.util;

public class StringUtil {
    public static boolean notEmpty(String s) {
        return s != null && !s.isEmpty();
    }

    public static boolean empty(String s) {
        return s == null || s.isEmpty();
    }
}
