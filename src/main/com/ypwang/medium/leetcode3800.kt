package com.ypwang.medium

class Solution3800 {
    fun minimumCost(s: String, t: String, flipCost: Int, swapCost: Int, crossCost: Int): Long {
        val c = LongArray(2)
        for (i in 0 until s.length)
            if (s[i] != t[i])
                c[s[i] - '0']++

        val (c0, c1) = c
        val res1 = (c0 + c1) * flipCost.toLong()
        val res2 = minOf(c0, c1) * swapCost.toLong() + Math.abs(c0 - c1) * flipCost.toLong()
        val res3 = minOf(c0,c1) * swapCost.toLong() + (Math.abs(c0 - c1) / 2) * (swapCost.toLong() + crossCost) + (Math.abs(c0 - c1) % 2) * flipCost.toLong()
        return minOf(res1, res2, res3)
    }
}
