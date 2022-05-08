package com.ypwang.medium

import com.ypwang.TreeNode

class Solution2265 {
    // return: current count, count of sub-tree, sum of sub-tree
    private fun helper(node: TreeNode?): Triple<Int, Int, Int> {
        if (node == null)
            return Triple(0, 0, 0)

        val (lr, lc, ls) = helper(node.left)
        val (rr, rc, rs) = helper(node.right)
        val sum = node.`val` + ls + rs
        val count = lc + rc + 1
        var rst = lr + rr
        if (sum / count == node.`val`)
            rst++

        return Triple(rst, count, sum)
    }

    fun averageOfSubtree(root: TreeNode?): Int =
        helper(root).first
}