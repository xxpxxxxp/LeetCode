package com.ypwang.easy

class Solution2389 {
    fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
        nums.sort()
        val rst = IntArray(queries.size)

        var idx = 0
        var sum = 0
        for ((i, v) in queries.withIndex().sortedBy { it.value }) {
            while (idx < nums.size && sum + nums[idx] <= v)
                sum += nums[idx++]

            rst[i] = idx
        }

        return rst
    }
}