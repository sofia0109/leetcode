package com.leetcode.algorithm;

/**
 *
 * Given an input string, reverse the string word by word.
   For example,
   Given s = "the sky is blue",
   return "blue is sky the".
 *
 * @Author yujianmei 2017-09-19
 */
public class A186_M_ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        //Notice: all the while loop, pay attention to index out of bounder.
        while (start <= end && isSpace(s, start)) {
            start++;
        }
        while (end >= 0 && isSpace(s, end)) {
            end--;
        }
        int pre = end;
        while (pre >= start) {
            while (pre >= start && !isSpace(s, pre)) pre--;
            sb.append(s.substring(pre + 1, end + 1));
            sb.append(" ");
            while (pre >= start && isSpace(s, pre)) pre--;
            end = pre;
        }
        //Notice: remove space at the end of String
        return sb.toString().trim();
    }

    private boolean isSpace(String s, int index) {
        return Character.isSpaceChar(s.charAt(index));
    }
}
