package com.ypwang.medium

class Solution2343 {
    fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {
        val ans = IntArray(queries.size)
        for ((i, arr) in queries.withIndex()) {
            val (k, trim) = arr
            ans[i] = nums.withIndex()
                .map { it.index to it.value.substring(it.value.length-trim) }
                .sortedBy { it.second }[k-1]
                .first
        }
        return ans
    }
}