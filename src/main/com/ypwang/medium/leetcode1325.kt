package com.ypwang.medium

class Solution1325 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        fun inner(r: TreeNode?): Boolean {
            if (r == null) return true
            if (inner(r.left)) r.left = null
            if (inner(r.right)) r.right = null
            return r.left == null && r.right == null && r.`val` == target
        }

        return if (inner(root)) null else root
    }
}