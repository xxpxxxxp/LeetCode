package com.ypwang.medium

class Solution962 {
    fun maxWidthRamp(A: IntArray): Int {
        val candidates = mutableListOf<Pair<Int, Int>>()

        var max = 0
        for ((i, v) in A.withIndex()) {
            val idx = candidates.binarySearch { v - it.first }.let { if (it < 0) -it - 1 else it }
            if (idx < candidates.size && i - candidates[idx].second > max) max = i - candidates[idx].second

            if (candidates.isEmpty() || v < candidates.last().first)
                candidates.add(v to i)
        }

        return max
    }
}

fun main() {
    println(Solution962().maxWidthRamp(intArrayOf(9,8,1,0,1,9,4,0,4,1)))
}