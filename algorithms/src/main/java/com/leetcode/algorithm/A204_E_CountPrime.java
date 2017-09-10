package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * Hello world!
 * <p>
 * Created by yujianmei on 2017-09-10
 */
public class A204_E_CountPrime {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                for (int j = i * 2; j < n; j = j + i) {
                    prime[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) cnt++;
        }
        return cnt;
    }
}
