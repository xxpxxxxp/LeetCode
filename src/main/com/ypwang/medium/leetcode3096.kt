package com.ypwang.medium

class Solution3096 {
    fun minimumLevels(possible: IntArray): Int {
        for ((i, v) in possible.withIndex()) {
            if (v == 0)
                possible[i] = -1
        }

        val sum = possible.sum()
        var preSum = possible[0]
        var i = 1
        while (i < possible.size && preSum <= sum - preSum)
            preSum += possible[i++]

        return if (i == possible.size) -1 else i
    }
}

fun main() {
    println(Solution3096().minimumLevels(intArrayOf(1,0,1,0)))
    println(Solution3096().minimumLevels(intArrayOf(1,1,1,1,1)))
    println(Solution3096().minimumLevels(intArrayOf(0,0)))
}
