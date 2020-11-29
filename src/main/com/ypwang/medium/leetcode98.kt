package com.ypwang.medium

import com.ypwang.TreeNode

class Solution98 {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null)
            return true

        fun helper(r: TreeNode?, leftbound: Int?, rightbound: Int?): Boolean {
            return if (r == null) true
            else
                leftbound?.let { r.`val` > it } ?: true &&
                rightbound?.let { r.`val` < it } ?: true &&
                helper(r.left, leftbound, r.`val`) &&
                helper(r.right, r.`val`, rightbound)
        }

        return helper(root.left, null, root.`val`) && helper(root.right, root.`val`, null)
    }
}

fun main() {
    val root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)
    println(Solution98().isValidBST(root))
}