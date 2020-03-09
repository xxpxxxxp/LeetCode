package com.ypwang.medium

class Solution1372 {
    private var rst = 0

    fun helper(node: TreeNode?, isLeft: Boolean): Int {
        if (node == null) return 0
        val left = helper(node.left, false)
        val right = helper(node.right, true)
        rst = maxOf(rst, left, right)
        return 1 + if (isLeft) left else right
    }

    fun longestZigZag(root: TreeNode?): Int {
        helper(root, true)
        return rst
    }
}