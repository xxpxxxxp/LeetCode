package com.ypwang.medium

import com.ypwang.TreeNode

class Solution102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }

        val rst = mutableListOf<List<Int>>()
        var cur = listOf(root)
        while (!cur.isEmpty()) {
            rst.add(cur.map { it.`val` })
            val new = mutableListOf<TreeNode>()
            cur.forEach { me ->
                me.left?.let { new.add(it) }
                me.right?.let { new.add(it) }
            }
            cur = new
        }

        return rst
    }
}