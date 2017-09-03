package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * Created by yujianmei on 2017/09/03.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class A102_M_BinaryTreeLevelOrder {

    /**
     *
     * This algorithm should be classified as easy! !
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);

        while (!curLevel.isEmpty()) {
            List<Integer> curVals = new ArrayList<>();
            ArrayList<TreeNode> temp = new ArrayList<>();
            for (TreeNode treeNode : curLevel) {
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
                curVals.add(treeNode.val);
            }
            result.add(curVals);
            curLevel = temp;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
