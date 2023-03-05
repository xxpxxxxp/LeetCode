package com.ypwang.medium

import java.math.BigInteger

class Solution2580 {
    fun countWays(ranges: Array<IntArray>): Int {
        ranges.sortBy { it[0] }
        var rst = 0L
        var end = -1
        for ((s, e) in ranges) {
            if (end < s)
                rst++

            end = maxOf(end, e)
        }

        return BigInteger.TWO.modPow(BigInteger.valueOf(rst), BigInteger.valueOf(1000000007)).toInt()
    }
}

fun main() {
    println(Solution2580().countWays(arrayOf(intArrayOf(6,10), intArrayOf(5,15))))
    println(Solution2580().countWays(arrayOf(intArrayOf(1,3), intArrayOf(10,20), intArrayOf(2,5), intArrayOf(4,8))))
}