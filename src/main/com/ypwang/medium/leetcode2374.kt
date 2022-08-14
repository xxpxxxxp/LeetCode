package com.ypwang.medium

class Solution2374 {
    fun edgeScore(edges: IntArray): Int {
        val score = LongArray(edges.size)
        for ((f, t) in edges.withIndex())
            score[t] = score[t] + f
        return score.withIndex().groupBy { it.value }.toList().maxByOrNull { it.first }!!.second.map { it.index }.minOrNull()!!
    }
}
