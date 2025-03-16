package com.ypwang.medium

class Solution3488 {
    fun solveQueries(nums: IntArray, queries: IntArray): List<Int> {
        val sz = nums.size
        val indices = mutableMapOf<Int, MutableList<Int>>()
        for ((i, v) in nums.withIndex())
            indices.getOrPut(v) { mutableListOf() }.add(i)

        for (arr in indices.values) {
            val m = arr.size
            if (m == 1) {
                nums[arr[0]] = -1
                continue
            }
            for (i in arr.indices) {
                val j = arr[i]
                val f = arr[(i + 1) % m]
                val b = arr[(i - 1 + m) % m]
                val forward = minOf((sz - j - 1) + f + 1, Math.abs(j - f))
                val backward = minOf(Math.abs(b - j), j + (sz - b))
                nums[j] = minOf(backward, forward)
            }
        }
        return queries.map { nums[it] }
    }
}
