package com.ypwang.hard

class Solution1012 {
    private fun A(m: Int, n: Int): Int =
            if (n == 0) 1 else A(m, n-1) * (m - n + 1)

    fun numDupDigitsAtMostN(N: Int): Int {
        val t = mutableListOf<Int>()
        var n = N + 1
        while (n > 0) {
            t.add(n % 10)
            n /= 10
        }
        val L = t.reversed().toIntArray()

        var rst = 0
        for (i in 1 until L.size) rst += A(9, i - 1)
        rst *= 9

        val set = mutableSetOf<Int>()
        for (i in L.indices) {
            for (j in (if (i > 0) 0 else 1) until L[i]) {
                if (j !in set) rst += A(9 - i, L.size - i - 1)
            }
            if (L[i] in set) break
            set.add(L[i])
        }

        return N - rst
    }
}

fun main() {
    println(Solution1012().numDupDigitsAtMostN(20))
}