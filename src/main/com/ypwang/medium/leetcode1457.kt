package com.ypwang.medium

class Solution1457 {
    private fun helper(node: TreeNode, count: IntArray): Int {
        count[node.`val`]++
        val rst =
        if (node.left == null && node.right == null) {
            if (count.count { it % 2 == 1 } < 2) 1 else 0
        } else {
            (node.left?.let { helper(it, count) } ?: 0) + (node.right?.let { helper(it, count) } ?: 0)
        }

        count[node.`val`]--
        return rst
    }

    fun pseudoPalindromicPaths (root: TreeNode?): Int {
        if (root == null) return 0
        return helper(root, IntArray(26))
    }
}