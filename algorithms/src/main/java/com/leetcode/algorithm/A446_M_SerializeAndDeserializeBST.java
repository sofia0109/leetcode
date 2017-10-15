package com.leetcode.algorithm;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * tored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized
 * to the original tree structure.
 * The encoded string should be as compact as possible.
 * <p>
 * Created by yujianmei on 2017-10-14
 */
public class A446_M_SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val);
            sb.append(",");
            if (node.left != null) {
                serialize(node.left, sb);
            }
            if (node.right != null) {
                serialize(node.right, sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] children = data.split(",");
        int[] ints = string2Int(children);
        if (children.length > 0) {
            return deserialize(ints, 0, ints.length - 1);
        }
        return null;
    }

    /**
     *
     *
     * @param ints
     * @param begin inclusive
     * @param end inclusive
     * @return
     */
    private TreeNode deserialize(int[] ints, int begin, int end) {
        if (begin > end) return null;
        TreeNode node = new TreeNode(ints[begin]);
        int pivot = pivot(ints, node.val, begin + 1, end);
        node.left = deserialize(ints, begin + 1, pivot - 1);
        node.right = deserialize(ints, pivot, end);
        return node;
    }

    private int pivot(int[] arr, int v, int begin, int end) {
        int index = begin;
        while (index <= end && arr[index] < v) {
            index++;
        }
        return index;
    }

    private int[] string2Int(String[] str) {
        int[] result = new int[str.length];
        int index = 0;
        for (String s : str) {
            result[index++] = Integer.valueOf(s);
        }
        return result;
    }
}
