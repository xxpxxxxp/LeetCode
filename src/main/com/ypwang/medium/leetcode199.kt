package com.ypwang.medium

import com.ypwang.TreeNode

class Solution199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }

        var level = listOf(root)
        val rst = mutableListOf<Int>()

        while (!level.isEmpty()) {
            rst.add(level.last().`val`)
            val next = mutableListOf<TreeNode>()
            level.forEach {
                it.left?.let { l -> next.add(l) }
                it.right?.let { r -> next.add(r) }
            }
            level = next
        }

        return rst
    }
}