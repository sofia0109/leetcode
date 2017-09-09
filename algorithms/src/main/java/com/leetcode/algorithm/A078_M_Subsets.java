package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Created by yujianmei on 2019-09-09
 */
public class A078_M_Subsets
{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //[] is subset of every one
        result.add(new ArrayList<>());

        if (nums == null || nums.length == 0) {
            return result;
        }

        return result;
    }

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }
}
