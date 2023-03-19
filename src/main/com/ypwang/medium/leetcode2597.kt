package com.ypwang.medium

class Solution2597 {
    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        var rst = 1
        for (group in nums.groupBy { it % k }.map { it.value }) {
            var prev = 0
            var dp0 = 1
            var dp1 = 0
            for ((a, c) in group.groupBy { it }.toList().sortedBy { it.first }) {
                val v = (1 shl c.size) - 1
                if (prev + k == a) {
                    val t = dp0 * v
                    dp0 += dp1
                    dp1 = t
                } else {
                    dp0 += dp1
                    dp1 = dp0 * v
                }
                prev = a
            }
            rst *= (dp0 + dp1)
        }
        return rst - 1
    }
}
