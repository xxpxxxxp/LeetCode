package com.ypwang.medium

class Solution2602 {
    fun minOperations(nums: IntArray, queries: IntArray): List<Long> {
        nums.sort()
        val size = nums.size
        var i = 0
        var preSum = 0L
        var postSum = nums.fold(0L) { a, b -> a + b }
        val rst = LongArray(queries.size)
        for ((j, v) in queries.withIndex().sortedBy { it.value }) {
            while (i < size && nums[i] <= v) {
                preSum += nums[i]
                postSum -= nums[i]
                i++
            }

            rst[j] = i.toLong() * v - preSum + postSum - (size - i.toLong()) * v
        }

        return rst.toList()
    }
}
