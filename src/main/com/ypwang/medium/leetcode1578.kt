package com.ypwang.medium

class Solution1578 {
    fun minCost(s: String, cost: IntArray): Int {
        var rst = 0
        var sum = 0
        var max = Int.MIN_VALUE

        var k = '-'

        for ((i, c) in s.withIndex()) {
            if (c != k) {
                if (i != 0) {
                    rst += sum - max
                }

                sum = 0
                max = Int.MIN_VALUE

                k = c
            }

            sum += cost[i]
            max = maxOf(max, cost[i])
        }

        return rst + sum - max
    }
}