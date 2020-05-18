package com.ypwang.medium

class Solution1448 {
    private fun helper(node: TreeNode?, preMax: Int): Int {
        if (node == null) return 0
        val max = maxOf(preMax, node.`val`)
        val cur = if (node.`val` >= preMax) 1 else 0
        return cur + helper(node.left, max) + helper(node.right, max)
    }

    fun goodNodes(root: TreeNode?): Int = helper(root, Int.MIN_VALUE)
}