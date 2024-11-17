package com.ypwang.medium

class Solution3356 {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        fun isZeroArray(k: Int): Boolean {
            val line = IntArray(nums.size + 1)

            for (i in 0 until k) {
                val (start, end, value) = queries[i]
                line[start] += value
                if (end + 1 < line.size) {
                    line[end + 1] -= value
                }
            }

            var cur = 0
            for (i in nums.indices) {
                cur += line[i]
                if (nums[i] > cur)
                    return false
            }
            return true
        }

        var l = 0
        var r = queries.size + 1

        while (l < r) {
            val m = (l + r) / 2
            if (isZeroArray(m))
                r = m
            else
                l = m + 1
        }

        return if (l <= queries.size) l else -1
    }
}
