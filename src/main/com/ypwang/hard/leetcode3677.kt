package com.ypwang.hard

class Solution3677 {
    private fun makePalin(left: Long, odd: Boolean): Long {
        var left = left
        var ans = left
        if (odd)
            left = left shr 1
        while (left > 0) {
            ans = (ans shl 1) or (left and 1L)
            left = left shr 1
        }
        return ans
    }

    fun countBinaryPalindromes(n: Long): Int {
        if (n == 0L)
            return 1
        val len = 64 - java.lang.Long.numberOfLeadingZeros(n)
        var count = 1L
        for (i in 1 until len) {
            val half = (i + 1) / 2
            count += 1L shl (half - 1)
        }
        val half = (len + 1) / 2
        val prefix = n shr (len - half)
        val palin = makePalin(prefix, len % 2 == 1)
        count += (prefix - (1L shl (half - 1)))
        if (palin <= n)
            ++count
        return count.toInt()
    }
}
