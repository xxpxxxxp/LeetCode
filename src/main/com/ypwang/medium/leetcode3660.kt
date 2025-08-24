package com.ypwang.medium

class Solution3660 {
    fun maxValue(nums: IntArray): IntArray {
        val n = nums.size
        val S = nums.clone()

        for (i in n - 2 downTo 0)
            S[i] = minOf(S[i], S[i + 1])

        val ans = mutableListOf<Int>()
        var m = 0
        for ((i, v) in nums.withIndex()) {
            m = maxOf(m, v)
            if (i == n - 1 || m <= S[i + 1])
                repeat(i + 1 - ans.size) { ans.add(m) }
        }

        return ans.toIntArray()
    }
}
