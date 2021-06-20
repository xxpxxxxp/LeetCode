package com.ypwang.medium

class Solution1906 {
    fun minDifference(nums: IntArray, queries: Array<IntArray>): IntArray {
        val rst = IntArray(queries.size)
        val idxs = Array(101) { mutableListOf<Int>() }

        for ((i, v) in nums.withIndex())
            idxs[v].add(i)

        for (i in queries.indices) {
            val (l, r) = queries[i]
            var prev = -1
            var delta = Int.MAX_VALUE

            for (j in 1..100) {
                val idx = idxs[j].binarySearch(l).let { if (it >= 0) it else -it-1 }
                if (idx < idxs[j].size && idxs[j][idx] <= r) {
                    if (prev > 0)
                        delta = minOf(delta, j - prev)
                    prev = j
                }
            }

            rst[i] = if (delta == Int.MAX_VALUE) -1 else delta
        }

        return rst
    }
}

fun main() {
    println(Solution1906().minDifference(intArrayOf(1,3,4,8),
            arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(2,3),intArrayOf(0,3))).toList())
}