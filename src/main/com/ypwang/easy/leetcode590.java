package com.ypwang.easy;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution590 {
    public void postorderhelper(Node root, List<Integer> result) {
        if (root.children != null) {
            for (Node n : root.children) {
                postorderhelper(n, result);
            }
            result.add(root.val);
        }
    }
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> rst = new ArrayList<>();
        postorderhelper(root, rst);
        return rst;
    }
}