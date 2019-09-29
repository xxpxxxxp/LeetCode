package com.ypwang.medium

class Solution1201 {
    private fun gcd(a: Long, b: Long): Long {
        if (a == 0L) return b
        return gcd(b % a, a)
    }

    private fun gca(a: Long, b: Long): Long {
        return (b / gcd(a, b)) * a
    }

    fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
        val (a1, b1, c1) = listOf(a, b, c).map { it.toLong() }.sorted()

        val ab = gca(a1, b1)
        val ac = gca(a1, c1)
        val bc = gca(b1, c1)
        val all = gca(ab, c1)

        var left = 1
        var right = Int.MAX_VALUE

        while (left < right) {
            val mid = left + (right - left) / 2
            val sum = (mid / a1) + (mid / b1) + (mid / c1) - (mid / ab) - (mid / ac) - (mid / bc) + (mid / all)

            if (sum < n) left = mid + 1
            else right = mid
        }

        return left
    }
}

fun main() {
    println(Solution1201().nthUglyNumber(1000000000
            ,2,
            217983653,
            336916467
    ))
}