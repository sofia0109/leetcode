package com.leetcode.algorithm;

import java.util.*;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words,
 * i.e. words[i] + words[j] is a palindrome.
 *
 * Created by yujianmei on 2017-10-30
 */
public class A336_H_PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0, len = words.length; i < len; i++) {
            index.put(words[i], i);
        }

        for (int i = 0, len = words.length; i < len; i++) {
            String s = words[i];
            for (int j = 0; j <= s.length(); j++) {
                String left = s.substring(0, j);
                String right = s.substring(j);
                String revLeft = reverse(left);
                String refRight = reverse(right);
                if (palindrome(left) && index.containsKey(refRight) && index.get(refRight) != i) {
                    result.add(Arrays.asList(index.get(refRight), i));
                }
                //note: right.length() > 0 to avoid duplicate.
                if (palindrome(right) && index.containsKey(revLeft) && index.get(revLeft) != i && right.length() > 0) {
                    result.add(Arrays.asList(i, index.get(revLeft)));
                }
            }
        }
        return result;
    }

    private boolean palindrome(String s) {
        int head = -1, tail = s.length();
        while (++head <= --tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
        }
        return true;
    }

    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        A336_H_PalindromePairs pairs = new A336_H_PalindromePairs();
        //failed to pass this test case as reverse("abcd") equals "dcba", will produce duplicate.
        String[] str = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> x = pairs.palindromePairs(str);
        for (List<Integer> integers : x) {
            System.out.println(integers);
        }
    }
}
