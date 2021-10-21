package com.ypwang.medium

import com.ypwang.TreeNode

class Solution515 {
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }

        var level = listOf(root)
        val rst = mutableListOf<Int>()

        while (!level.isEmpty()) {
            rst.add(level.maxByOrNull { it.`val` }!!.`val`)
            val tmp = mutableListOf<TreeNode>()
            for (t in level) {
                t.left?.let { tmp.add(it) }
                t.right?.let { tmp.add(it) }
            }
            level = tmp
        }
        return rst
    }
}