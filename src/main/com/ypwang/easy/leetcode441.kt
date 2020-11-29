package com.ypwang.easy

class Solution441 {
    fun arrangeCoins(n: Int): Int {
        var begin = 0
        var end = 6

        while (begin + 1 < end)
        {
            val mid = begin + (end - begin) / 2
            val target = (mid / 2) * (mid + 1)
            when {
                target > n -> end = mid
                else -> begin = mid
            }
        }
        return begin
    }
}

fun main() {
    println(Solution441().arrangeCoins(5))
}