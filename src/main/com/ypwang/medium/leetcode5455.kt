package com.ypwang.medium

class Solution5455 {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        fun check(day: Int): Boolean {
            var continues = 0
            var count = 0

            for (i in bloomDay) {
                if (day >= i) continues++ else continues = 0

                if (continues == k) {
                    count++
                    continues = 0
                }

                if (count == m) return true
            }

            return false
        }

        var left = 0
        var right = bloomDay.maxOrNull()!!

        while (left < right) {
            val mid = (left + right) / 2
            if (check(mid)) right = mid
            else left = mid + 1
        }

        return if (check(left)) left else -1
    }
}

fun main() {
    println(Solution5455().minDays(intArrayOf(1,10,3,10,2), 3, 1))
    println(Solution5455().minDays(intArrayOf(1,10,3,10,2), 3, 2))
    println(Solution5455().minDays(intArrayOf(7,7,7,7,12,7,7), 2, 3))
    println(Solution5455().minDays(intArrayOf(1000000000,1000000000), 1, 1))
    println(Solution5455().minDays(intArrayOf(1,10,2,9,3,8,4,7,5,6), 4, 2))
}