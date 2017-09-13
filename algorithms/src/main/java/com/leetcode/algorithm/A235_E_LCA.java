package com.leetcode.algorithm;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * Created by yujianmei on 2017-09-13
 */
public class A235_E_LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        boolean larger = (p.val - q.val) > 0;
        if (larger) {
            if (root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (root.val > p.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (root.val > q.val && root.val < p.val) {
                return root;
            }
        }
        return lowestCommonAncestor(root, q, p);
    }
}
