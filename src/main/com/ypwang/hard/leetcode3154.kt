package com.ypwang.hard

class Solution3154 {
    private fun comb(n: Int, k: Int): Int {
        if (k < 0 || k > n)
            return 0
        var res = 1L
        for (i in 0 until k)
            res = res * (n - i) / (i + 1)
        return res.toInt()
    }

    fun waysToReachStair(k: Int): Int {
        var res = 0
        for (j in 0..30)
            res += comb(j + 1, (1 shl j) - k)
        return res
    }
}
