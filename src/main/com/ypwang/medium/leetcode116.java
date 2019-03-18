package com.ypwang.medium;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class leetcode116 {
    public Node connect(Node root) {
        LinkedList<Node> level = new LinkedList<>();

        if (root != null)
            level.add(root);

        while (!level.isEmpty()) {
            LinkedList<Node> nextLevel = new LinkedList<>();

            Node cur = null;
            for (Node node: level) {
                if (cur != null)
                    cur.next = node;

                cur = node;
                if (cur.left != null) {
                    nextLevel.add(cur.left);
                }
                if (cur.right != null) {
                    nextLevel.add(cur.right);
                }
            }

            level = nextLevel;
        }

        return root;
    }
}