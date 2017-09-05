package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * <p>
 * Created by yujianmei on 2017/09/01.
 */
public class A017_E_LetterComOfPhoneNum {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        String[] tables = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        letterCombinations(result, digits, "", 0, tables);
        return result;
    }

    private void letterCombinations(List<String> list, String digits, String cur, int depth, String[] tables) {
        if (depth == digits.length()) {
            list.add(cur);
            return;
        }

        int index = digits.charAt(depth) - '0';
        String table = tables[index];
        for (int i = 0, len = table.length(); i < len; i++) {
            String append = cur + table.charAt(i);
            letterCombinations(list, digits, append, depth + 1, tables);
        }
    }
}
