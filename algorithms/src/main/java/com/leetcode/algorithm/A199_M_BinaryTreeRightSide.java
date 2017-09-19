package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it
 * return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *
 * @Author yujianmei 2017-09-19
 */
public class A199_M_BinaryTreeRightSide {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (n == 0) {
                    ret.add(cur.val);
                }
            }
        }
        return ret;
    }

    public List<Integer> rightSideViewV2(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        dfs(root, ret, 0);
        return ret;
    }

    private void dfs(TreeNode node, ArrayList<Integer> result, int depth) {
        if (node == null) return;
        if (depth == result.size()) {
            result.add(node.val);
        }
        dfs(node.right, result, depth + 1);
        dfs(node.left, result, depth + 1);
    }
}
