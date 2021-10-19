package com.ypwang.medium

import com.ypwang.TreeNode

class Solution1609 {
    private fun helper(nodes: List<TreeNode>, odd: Boolean): Boolean {
        if (nodes.isEmpty()) return true

        val cur =
                if (odd) {
                    nodes.map { it.`val` }.toTypedArray().let {
                        it.all { i -> i % 2 == 0 } && (0 until it.lastIndex).all { i -> it[i] > it[i+1] }
                    }
                } else {
                    nodes.map { it.`val` }.toTypedArray().let {
                        it.all { i -> i % 2 == 1 } && (0 until it.lastIndex).all { i -> it[i] < it[i+1] }
                    }
                }

        return cur && helper(nodes.flatMap { listOf(it.left, it.right) }.filterNotNull(), !odd)
    }

    fun isEvenOddTree(root: TreeNode?): Boolean = helper(listOf(root!!), false)
}