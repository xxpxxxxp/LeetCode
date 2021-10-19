package com.ypwang.medium;

import com.ypwang.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int countnull = 0;
            while (!queue.isEmpty() && queue.peek() == null) {
                queue.poll();
                countnull++;
            }

            if (!queue.isEmpty()) {
                for (int i = 0; i < countnull; i++) {
                    sb.append(';');
                }

                TreeNode cur = queue.poll();
                sb.append(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
                sb.append(';');
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] queue = data.split(";");
        Queue<Integer> its = new LinkedList<>();

        for (String s: queue) {
            if (s.isEmpty()) {
                its.add(null);
            } else {
                its.add(Integer.parseInt(s));
            }
        }

        TreeNode root = new TreeNode(its.poll());
        Queue<TreeNode> fetch = new LinkedList<>();
        fetch.add(root);

        while (true) {
            TreeNode cur = fetch.poll();
            if (!its.isEmpty()) {
                Integer i = its.poll();
                if (i != null) {
                    cur.left = new TreeNode(i);
                    fetch.add(cur.right);
                }
            } else {
                break;
            }

            if (!its.isEmpty()) {
                Integer i = its.poll();
                if (i != null) {
                    cur.left = new TreeNode(i);
                    fetch.add(cur.right);
                }
            } else {
                break;
            }
        }

        return root;
    }
}