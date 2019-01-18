package com.ypwang.easy;

import java.util.*;

class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rst = new LinkedList<>();
        if (root == null) {
            return rst;
        }
        List<Node> tmp = new LinkedList<>();
        tmp.add(root);

        while (!tmp.isEmpty()) {
            List<Node> tmp2 = new LinkedList<>();
            List<Integer> tmp1 = new LinkedList<>();
            for (Node t : tmp) {
                tmp1.add(root.val);
                tmp2.addAll(t.children);
            }
            rst.add(tmp1);
            tmp = tmp2;
        }

        return rst;
    }
}