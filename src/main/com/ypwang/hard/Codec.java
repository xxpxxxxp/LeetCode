package com.ypwang.hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node.

 */
public class Codec {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        return Integer.toString(root.val) + ',' + serialize(root.left) + ',' + serialize(root.right);
    }

    private TreeNode parse(Queue<Character> data) {
        if (data.peek() == null || data.peek() == ',') return null;
        else {
            int a = 0;
            boolean negative = false;
            while (data.peek() != null && data.peek() != ',') {
                if (data.peek() == '-') {
                    data.poll();
                    negative = true;
                } else {
                    a = a * 10 + (data.poll() - '0');
                }
            }

            if (negative) a = -a;

            TreeNode root = new TreeNode(a);
            if (data.peek() != null) {
                data.poll();
                root.left = parse(data);
                data.poll();
                root.right = parse(data);
            }

            return root;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return parse(new LinkedList<>(data.chars().mapToObj(i -> (char) i).collect(Collectors.toList())));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String rst = codec.serialize(root);
        System.out.println(rst);
        codec.deserialize(rst);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));