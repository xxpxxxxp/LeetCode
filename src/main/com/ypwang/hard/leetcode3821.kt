package com.ypwang.hard

class Solution3821 {
    fun nthSmallest(n: Long, k: Int): Long {
        var n = n
        var k = k
        val comb = Array(51) { LongArray(51) }
        for (i in 0..50) {
            comb[i][0] = 1
            for (j in 1..i)
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j]
        }
        var res = 0L
        for (i in 49 downTo 0) {
            val c = comb[i][k]
            if (n > c) {
                res = res or (1L shl i)
                n -= c
                if (--k == 0)
                    break
            }
        }
        return res
    }
}
