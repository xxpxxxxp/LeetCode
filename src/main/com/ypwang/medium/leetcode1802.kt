package com.ypwang.medium

class Solution1802 {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        fun helper(i: Int): Long {
            val l = minOf(i-1, index).toLong()
            val r = minOf(i-1, n - 1 - index).toLong()
            return i * (l + r + 1) - l * (l + 1) / 2 - r * (r + 1) / 2 + n - 1 - l - r
        }

        var left = 1
        var right = maxSum

        while (left < right) {
            val mid = (left + right + 1) / 2
            if (helper(mid) <= maxSum) {
                left = mid
            } else {
                right = mid - 1
            }
        }

        return left
    }
}

fun main() {
    println(Solution1802().maxValue(4,2,6))
    println(Solution1802().maxValue(6,1,10))
    println(Solution1802().maxValue(3,2,18))
}