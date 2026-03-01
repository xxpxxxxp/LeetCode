package com.ypwang.easy

class Solution3852 {
    fun minDistinctFreqPair(nums: IntArray): IntArray {
        val r = nums
            .groupBy { it }
            .asSequence()
            .map { it.key to it.value.size }
            .groupBy { it.second }
            .map { it.value.map { kv -> kv.first }.min() }
            .sorted()
            .take(2)
            .toList()

        return if (r.size < 2) intArrayOf(-1, -1) else r.toIntArray()
    }
}
