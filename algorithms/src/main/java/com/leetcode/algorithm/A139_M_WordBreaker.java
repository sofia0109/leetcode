package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 *
 * Created by yujianmei on 2017-09-18
 */
public class A139_M_WordBreaker {
    /**
     * if result[j] is true, mean [0,j-1] is in dic.
     * [0...j...i]
     * word will break at index j-1
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] result = new boolean[len + 1];
        result[0] = true;
        //notice: <= len. not <
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] && wordDict.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        //notice : return len..
        return result[len];
    }
}
