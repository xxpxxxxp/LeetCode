package com.ypwang.easy;

import java.util.Iterator;
import java.util.Stack;

class Solution235 {
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public Boolean findPath(TreeNode root, TreeNode p, Stack<TreeNode> path) {
        if (root != null) {
            path.add(root);
            if (root.val == p.val) {
                return true;
            }
            if (findPath(root.left, p, path)) {
                return true;
            }
            if (findPath(root.right, p, path)) {
                return true;
            }
            path.pop();
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();
        findPath(root, p, ps);
        findPath(root, q, qs);
        Iterator<TreeNode> psi = ps.iterator();
        Iterator<TreeNode> qsi = qs.iterator();
        TreeNode rst = root;
        while (psi.hasNext() && qsi.hasNext())
        {
            TreeNode pn = psi.next();
            TreeNode qn = qsi.next();
            if (pn.val == qn.val) {
                rst = pn;
            } else {
                break;
            }
        }
        return rst;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        System.out.println(new Solution235().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)));
    }
}