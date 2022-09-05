package com.ypwang.medium

class Solution2400 {
    val mod = 1000000007
    fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
        if ((startPos - endPos - k) % 2 != 0) return 0
        if (Math.abs(startPos - endPos) > k) return 0
        var res = 1L
        for (i in 0 until (endPos - startPos + k) / 2) {
            res = res * (k - i) % mod
            res = res * inv((i + 1).toLong()) % mod
        }
        return res.toInt()
    }

    private fun inv(a: Long): Long {
        return if (a == 1L) 1L else (mod - mod / a) * inv(mod % a) % mod
    }
}