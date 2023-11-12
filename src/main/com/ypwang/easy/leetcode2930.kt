package com.ypwang.easy

class Solution2930 {
    private fun powerMod(x: Long, n: Long, mod: Long): Long {
        var n = n
        var result = 1L
        var p = x % mod
        while (n != 0L) {
            if (n and 1L != 0L)
                result = result * p % mod
            p = p * p % mod
            n = n shr 1
        }
        return result
    }

    fun stringCount(n: Int): Int {
        var count = 0L
        val mod = 1000000007L
        count = (count + powerMod(26, n.toLong(), mod)) % mod
        count = (count - (n + 75) * powerMod(25, (n - 1).toLong(), mod)) % mod
        count = (count + (2 * n + 72) * powerMod(24, (n - 1).toLong(), mod)) % mod
        count = (count - (n + 23) * powerMod(23, (n - 1).toLong(), mod)) % mod
        return ((count % mod + mod) % mod).toInt()
    }
}