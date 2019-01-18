package com.ypwang.easy;

import java.util.*;

public class leetcode589 {
    public static void main(String[] args) {

    }
}

class Solution589 {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Node> stack = new ArrayList<>();
        LinkedList<Integer> rst = new LinkedList<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            rst.add(cur.val);
            if (!cur.children.isEmpty()) {
                for (int i = (cur.children.size()-1); i >= 0; i--) {
                    stack.add(cur.children.get(i));
                }
            }
        }

        return rst;
    }
}