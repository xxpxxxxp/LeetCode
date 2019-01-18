package com.ypwang.easy

import com.ypwang.TreeNode

class Solution637 {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) {
            return doubleArrayOf()
        }

        val rst = mutableListOf<Double>()
        val row = mutableListOf(root)
        while (!row.isEmpty()) {
            val tmp = row.toMutableList()
            rst.add(row.sumByDouble { it.`val`.toDouble() } / row.size)
            row.clear()
            for (n in tmp) {
                n.left?.apply { row.add(this) }
                n.right?.apply { row.add(this) }
            }
        }

        return rst.toDoubleArray()
    }
}