package com.ypwang.hard

class Solution878 {
    private fun gca(A: Int, B: Int): Int {
        val (a, b) = if (A > B) A to B else B to A
        return if (b == 0) a else gca(b, a % b)
    }

    fun nthMagicalNumber(N: Int, A: Int, B: Int): Int {
        val g = A * B / gca(A, B)
        val c = g / A + g / B - 1

        val r = g.toLong() * (N / c)

        var l = N % c
        var i = 1
        var j = 1
        while (l-- > 0) {
            if (i * A > j * B) j++
            else i++
        }

        return ((r + maxOf((i-1) * A, (j-1) * B)) % 1000000007).toInt()
    }
}

fun main() {
    println(Solution878().nthMagicalNumber(946821463,12,18))
}