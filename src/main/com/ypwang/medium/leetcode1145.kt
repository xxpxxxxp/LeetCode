package com.ypwang.medium

class Solution1145 {
    private fun findX(root: TreeNode?, x: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == x) return root
        root.left?.let { findX(it, x) }?.let { return it }
        root.right?.let { findX(it, x) }?.let { return it }
        return null
    }

    private fun countX(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + countX(root.left) + countX(root.right)
    }

    fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
        val xt = findX(root, x)!!
        val l = countX(xt.left)
        val r = countX(xt.right)
        return maxOf(l, r, n-l-r-1) > n/2
    }
}