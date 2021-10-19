package com.ypwang.medium

import com.ypwang.TreeNode

class Solution1339 {
    fun maxProduct(root: TreeNode?): Int {
        var rst = 0L
        var total = 0L

        fun solve(root: TreeNode?): Long {
            if (root == null) return 0L
            val s = root.`val` + solve(root.left) + solve(root.right)
            rst = maxOf(rst, s * (total - s))
            return s
        }

        total = solve(root)
        solve(root)

        return (rst % 1000000007).toInt()
    }
}