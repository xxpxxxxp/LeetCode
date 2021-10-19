package com.ypwang.medium;

import com.ypwang.TreeNode;

import java.util.Stack;

class State {
    public State(TreeNode r) {
        state = 0;
        treeNode = r;
        tagged = false;
    }

    public int state;   // 0: init; 1: left on going; 2 right on going
    public TreeNode treeNode;
    public boolean tagged;
}

public class leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<State> trace = new Stack<>();
        trace.add(new State(root));

        TreeNode pqState = null;

        while (!trace.isEmpty()) {
            State cur = trace.peek();

            if (cur.treeNode == p || cur.treeNode == q) {
                if (pqState == null) {
                    for (State s : trace) {
                        s.tagged = true;
                    }
                    pqState = cur.treeNode;
                } else if (cur.treeNode != pqState) {
                    while (true) {
                        State s = trace.pop();
                        if (s.tagged) {
                            return s.treeNode;
                        }
                    }
                }
            }

            switch (cur.state) {
                case 0: {
                    if (cur.treeNode.left != null) {
                        trace.add(new State(cur.treeNode.left));
                    }
                    cur.state = 1;
                    break;
                }
                case 1: {
                    if (cur.treeNode.right != null) {
                        trace.add(new State(cur.treeNode.right));
                    }
                    cur.state = 2;
                    break;
                }
                case 2: {
                    trace.pop();
                    break;
                }
            }
        }

        return null;
    }
}
