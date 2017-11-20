package com.leetcode.algorithm;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every
 * third bulb (turning on if it's off or turning off if it's on). For the ith round,
 * you toggle every i bulb. For the nth round, you only toggle the last bulb.
 * Find how many bulbs are on after n rounds.
 * <p>
 * Created by yujianmei on 2017-11-20
 */
public class A319_M_BulbSwitcher {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * I just copied other's solution.
     *
     * @param n
     * @return
     */
    int bulbSwitchV2(int n) {
        return (int)Math.sqrt(n);
    }

    /**
     * This is mine, it works, but it may take too long.
     *
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        boolean[] values = new boolean[n + 1];
        //first round, turn on all the light. values[0] is omit
        for (int i = 1; i < values.length; i++) {
            values[i] = true;
        }
        for (int i = 2; i <= n; i++) {
            int j = i;
            while (j <= n) {
                flip(values, j);
                j += i;
            }
        }
        int cnt = 0;
        for (boolean value : values) {
            if (value) cnt++;
        }
        return cnt;
    }

    public void flip(boolean[] arr, int i) {
        arr[i] = !arr[i];
    }
}
