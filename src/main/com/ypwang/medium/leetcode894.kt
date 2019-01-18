package com.ypwang.medium

import com.ypwang.TreeNode

class Solution894 {
    fun allPossibleFBT(N: Int): List<TreeNode?> {
        if (N % 2 == 0) {
            return listOf()
        }

        if (N == 1) {
            return listOf(TreeNode(0))
        }

        val rst = mutableListOf<TreeNode?>()
        for (i in 1 until (N-1) step 2) {
            val lefts = allPossibleFBT(i)
            val rights = allPossibleFBT(N - i - 1)

            for (l in lefts) {
                for (r in rights) {
                    val root = TreeNode(0)
                    root.left = l
                    root.right = r
                    rst.add(root)
                }
            }
        }
        return rst
    }
}