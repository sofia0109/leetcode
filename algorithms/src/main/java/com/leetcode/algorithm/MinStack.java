package com.leetcode.algorithm;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Hello world!
 * <p>
 * Created by yujianmei on 2017-9-20
 */


public class MinStack {
    Stack<Integer> cur = new Stack();
    Stack<Integer> min = new Stack();

    public MinStack() {
    }

    public void push(int x) {
        cur.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if (cur.empty()) return;
        int pop = cur.pop();
        if (min.peek() == pop) {
            min.pop();
        }
    }

    public int top() {
        if (cur.empty()) {
            throw new IllegalStateException("empty");
        }
        return cur.peek();
    }

    public int getMin() {
        if (cur.empty()) {
            throw new IllegalStateException("empty");
        }
        return min.peek();
    }
}
