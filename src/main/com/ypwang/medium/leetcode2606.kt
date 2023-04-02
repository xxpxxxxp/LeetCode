package com.ypwang.medium

class Solution2606 {
    fun maximumCostSubstring(s: String, chars: String, vals: IntArray): Int {
        var rst = 0
        var cur = 0
        val cost = chars.indices.associate { chars[it] to vals[it] }

        for (c in s) {
            cur += cost[c] ?: (c - 'a' + 1)
            if (cur < 0)
                cur = 0

            rst = maxOf(rst, cur)
        }

        return rst
    }
}