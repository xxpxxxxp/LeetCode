package com.ypwang.medium

class Solution1492 {
    fun kthFactor(n: Int, k: Int): Int {
        var c = k
        var d = 1

        while (d * d <= n) {
            if (n % d == 0) {
                c--
            }

            if (c == 0) return d
            d++
        }

        d--
        if (d * d == n) c++

        while (d > 0) {
            if (n % d == 0) {
                c--
            }

            if (c == 0) return n / d
            d--
        }

        return -1
    }
}

fun main() {
    println(Solution1492().kthFactor(24, 6))
    println(Solution1492().kthFactor(12, 3))
    println(Solution1492().kthFactor(7, 2))
    println(Solution1492().kthFactor(4, 4))
    println(Solution1492().kthFactor(1, 1))
    println(Solution1492().kthFactor(1000, 3))
}