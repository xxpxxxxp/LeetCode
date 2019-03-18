package com.ypwang.medium

import com.ypwang.TreeNode

class Solution103 {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null)
            return listOf()

        val rst = mutableListOf<List<Int>>()
        var level = mutableListOf(root)
        var zigzag = false

        while (level.isNotEmpty()) {
            var l = level.map { it.`val` }
            if (zigzag) {
                l = l.reversed()
            }
            rst.add(l)

            val next = mutableListOf<TreeNode>()

            for (node in level) {
                node.left?.let { next.add(it) }
                node.right?.let { next.add(it) }
            }

            level = next
            zigzag = !zigzag
        }
        return rst
    }
}
