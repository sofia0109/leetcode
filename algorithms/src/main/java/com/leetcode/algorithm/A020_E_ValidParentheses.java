package com.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 *
 * Created by yujianmei on 2017/09/01.
 */
public class A020_E_ValidParentheses {


    /**
     *
     *
     * Note: pop() will throw EmptyStackException if stack is empty.
     *
     * Must check if the stack is empty before pop()
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                    return false;
                }
                if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                    return false;
                }
                if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
