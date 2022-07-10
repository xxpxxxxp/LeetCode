package com.ypwang.easy

import com.ypwang.TreeNode

class Solution2331 {
    fun evaluateTree(root: TreeNode?): Boolean = helper(root!!)

    private fun helper(root: TreeNode): Boolean {
        if (root.left == null && root.right == null)
            return root.`val` == 1

        val left = evaluateTree(root.left!!)
        if (left && root.`val` == 2)
            return true
        if (!left && root.`val` == 3)
            return false

        return evaluateTree(root.right!!)
    }
}