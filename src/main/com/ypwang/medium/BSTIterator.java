package com.ypwang.medium;

import com.ypwang.TreeNode;

import java.util.Stack;

public class BSTIterator {
    TreeNode root, cur;
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        this.root = root;
        cur = root;
        s = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.empty() || cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            s.push(cur);
            cur = cur.left;
        }

        TreeNode x = s.pop();
        cur = x.right;
        return x.val;
    }

    public static void main(String[] args) {
        System.out.println(new BSTIterator(null).hasNext());
    }
}