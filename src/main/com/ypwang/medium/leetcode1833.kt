package com.ypwang.medium

class Solution1833 {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        costs.sort()
        var c = 0
        for ((i, v) in costs.withIndex()) {
            c += v
            if (c > coins)
                return i
        }

        return costs.size
    }
}