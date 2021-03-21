package com.ypwang.medium

class Solution1798 {
    fun getMaximumConsecutive(coins: IntArray): Int {
        coins.sort()
        var rst = 0

        for (c in coins) {
            if (c > rst + 1)
                break

            rst += c
        }

        return rst + 1
    }
}

fun main() {
    println(Solution1798().getMaximumConsecutive(intArrayOf(1,3)))
    println(Solution1798().getMaximumConsecutive(intArrayOf(1,1,1,4)))
    println(Solution1798().getMaximumConsecutive(intArrayOf(1,4,10,3,1)))
}