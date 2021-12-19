package com.ypwang.medium

class Solution2110 {
    fun getDescentPeriods(prices: IntArray): Long {
        var idx = 0
        var cur = prices[0]

        var rst = 0L
        for (i in 1 until prices.size) {
            if (cur - 1 != prices[i]) {
                val d = i - idx
                rst += d.toLong() * (d+1) / 2
                idx = i
            }

            cur = prices[i]
        }

        val d = prices.size - idx
        return rst + d.toLong() * (d+1) / 2
    }
}

fun main() {
    println(Solution2110().getDescentPeriods(intArrayOf(3,2,1,4)))
}