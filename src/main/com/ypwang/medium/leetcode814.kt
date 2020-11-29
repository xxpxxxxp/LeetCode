package com.ypwang.medium

import com.ypwang.TreeNode

class Solution814 {
    fun helper(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }

        var left = true
        var right = true
        if (!helper(root.left)) {
            left = false
            root.left = null
        }

        if (!helper(root.right)) {
            right = false
            root.right = null
        }

        return root.`val` == 1 || left || right
    }

    fun pruneTree(root: TreeNode?): TreeNode? {
        return if (helper(root)) root else null
    }
}

fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(0)
    root.right!!.left = TreeNode(0)
    root.right!!.right = TreeNode(1)
    println(Solution814().pruneTree(root))
}
