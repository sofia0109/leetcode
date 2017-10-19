package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in
 * a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another
 * computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization
 * algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized
 * to the original tree structure.
 * <p>
 * Created by yujianmei on 2017-10-19
 */
public class A297_H_SerializeTree {
    private static final String SPLITTER = "#";
    private static final String NULL_NODE = "NULL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_NODE).append(SPLITTER);
        } else {
            sb.append(node.val).append(SPLITTER);
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> node = new LinkedList<>();
        node.addAll(Arrays.asList(data.split(SPLITTER)));
        if (node.isEmpty()) return null;
        return deserialize(node);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        String v = nodes.remove();
        if (NULL_NODE.equals(v)) return null;
        Integer intValue = Integer.valueOf(v);
        TreeNode node = new TreeNode(intValue);
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
