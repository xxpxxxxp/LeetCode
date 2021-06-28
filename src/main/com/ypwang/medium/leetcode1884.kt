package com.ypwang.medium

class Solution1884 {
    fun twoEggDrop(n: Int): Int {
        var lo = 1
        var hi = n
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (mid * (mid + 1) / 2 < n) lo = mid + 1
            else hi = mid
        }

        return lo
    }
}

fun main() {
    println(Solution1884().twoEggDrop(2))
    println(Solution1884().twoEggDrop(100))
}