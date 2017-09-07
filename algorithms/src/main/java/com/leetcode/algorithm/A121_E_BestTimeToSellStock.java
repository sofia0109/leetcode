package com.leetcode.algorithm;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * <p>
 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * Created by yujianmei on 2017-09-07
 */
public class A121_E_BestTimeToSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0, len = prices.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                }
            }
        }
        return max;
    }

    public int maxProfitV2(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0, len = prices.length; i < len; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
