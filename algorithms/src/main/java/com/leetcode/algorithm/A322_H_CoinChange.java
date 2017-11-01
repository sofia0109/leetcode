package com.leetcode.algorithm;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Created by yujianmei on 2017-11-01
 */
public class A322_H_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int result = -1;
        if (coins == null || coins.length == 0 || amount < 0) {
            return result;
        }
        int[] max = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            boolean changed = false;
            for (int coin : coins) {
                if (coin <= i && max[i - coin] != -1) {
                    max[i] = changed ? Math.min(1 + max[i - coin], max[i]) : 1 + max[i - coin];
                    changed = true;
                }
            }
            if (!changed) max[i] = -1;
        }
        return max[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int[] coins2 = {2};
        System.out.println(coinChange(coins, 11));
        //Question: how to handle this corner case?
        System.out.println(coinChange(coins2, 1));
    }
}
