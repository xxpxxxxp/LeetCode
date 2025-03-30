package com.ypwang.easy

class Solution3502 {
    fun minCosts(cost: IntArray): IntArray {
        val rst = IntArray(cost.size)
        var cur = Int.MAX_VALUE
        for ((i, v) in cost.withIndex()) {
            cur = minOf(cur, v)
            rst[i] = cur
        }

        return rst
    }
}
