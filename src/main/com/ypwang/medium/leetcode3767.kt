package com.ypwang.medium

class Solution3767 {
    fun maxPoints(technique1: IntArray, technique2: IntArray, k: Int): Long {
        var sum = 0L
        val n = technique1.size
        val res = technique1.zip(technique2).sortedByDescending { it.first - it.second }.toTypedArray()

        for (i in 0 until k)
            sum += res[i].first

        for (i in k until n)
            sum += maxOf(res[i].first, res[i].second)

        return sum
    }
}
