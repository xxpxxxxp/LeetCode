package com.ypwang.hard

class Solution3864 {
    fun minCost(s: String, encCost: Int, flatCost: Int): Long {
        val prefixSum = mutableListOf(0)
        for (ch in s)
            prefixSum.add(prefixSum.last() + (ch - '0'))

        fun minCost(l: Int, r: Int, encCost: Int, flatCost: Int): Long {
            val cnt = prefixSum[r] - prefixSum[l]
            val sz = r - l

            var cost = if (cnt != 0)
                cnt.toLong() * sz * encCost
            else
                flatCost.toLong()

            if (cnt != 0 && sz % 2 == 0) {
                val mid = l + sz / 2
                cost = minOf(
                    cost,
                    minCost(l, mid, encCost, flatCost) + minCost(mid, r, encCost, flatCost)
                )
            }

            return cost
        }

        return minCost(0, s.length, encCost, flatCost)
    }
}
