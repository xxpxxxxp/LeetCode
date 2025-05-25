package com.ypwang.easy

class Solution3560 {
    fun minCuttingCost(n: Int, m: Int, k: Int): Long {
        val x = maxOf(n, m)
        if (x <= k)
            return 0L

        return k.toLong() * (x - k)
    }
}
