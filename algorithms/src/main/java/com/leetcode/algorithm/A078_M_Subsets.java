package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Created by yujianmei on 2019-09-16
 */
public class A078_M_Subsets
{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        dfs(nums, 0, list, result);
        return result;
    }

    private void dfs(int[] nums, int pos, List<Integer> cur, List<List<Integer>> ret) {
        ret.add(new ArrayList<>(cur));
        for (int i = pos; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, i + 1, cur, ret);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new A078_M_Subsets().subsets(nums);
    }
}
