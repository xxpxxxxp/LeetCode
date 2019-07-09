package com.ypwang.hard

class Solution668 {
    fun findKthNumber(m: Int, n: Int, k: Int): Int {
        fun helper(x: Int): Boolean = (1..m).sumBy { minOf(n, x / it) } >= k

        var left = 1
        var right = m * n

        while (left < right) {
            val mid = (left + right) / 2

            if (helper(mid)) right = mid
            else left = mid + 1
        }

        return left
    }
}

fun main() {
    println(Solution668().findKthNumber(3, 3, 5))
}