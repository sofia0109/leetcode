package com.leetcode.algorithm;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Created by yujianmei on 2017-09-09
 */
public class A049_M_GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>(0);
        }

        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] original = str.toCharArray();
            Arrays.sort(original);
            String key = new String(original);
            List<String> v = m.computeIfAbsent(key, k -> new ArrayList<>());
            v.add(str);
        }
        List<List<String>> result = new ArrayList<>(strs.length);
        result.addAll(m.values());
        return result;
    }
}
