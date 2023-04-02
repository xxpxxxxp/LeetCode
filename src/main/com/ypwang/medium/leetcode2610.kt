package com.ypwang.medium

class Solution2610 {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val g = nums.groupBy { it }.mapValues { it.value.size }
        val rst = Array(g.values.max()!!) { mutableListOf<Int>() }

        for ((k, v) in g) {
            for (i in 0 until v) {
                rst[i].add(k)
            }
        }

        return rst.toList()
    }
}