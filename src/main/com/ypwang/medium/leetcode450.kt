package com.ypwang.medium

import com.ypwang.TreeNode

class Solution450 {
    private fun successor(root: TreeNode): Int {
        var r = root.right!!
        while (r.left != null) r = r.left!!
        return r.`val`
    }

    private fun predecessor(root: TreeNode): Int {
        var l = root.left!!
        while (l.right != null) l = l.right!!
        return l.`val`
    }

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        // delete from the right subtree
        if (key > root.`val`)
            root.right = deleteNode(root.right, key)
        else if (key < root.`val`)
            root.left = deleteNode(root.left, key)
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) return null
            else if (root.right != null) {
                root.`val` = successor(root)
                root.right = deleteNode(root.right, root.`val`)
            } else {
                root.`val` = predecessor(root)
                root.left = deleteNode(root.left, root.`val`)
            }
        }
        return root
    }
}