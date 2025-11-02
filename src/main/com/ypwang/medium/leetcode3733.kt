package com.ypwang.medium

class Solution3733 {
    private fun gcd(a: Long, b: Long): Long =
        if (a == 0L) b else gcd(b % a, a)

    fun minimumTime(d: IntArray, r: IntArray): Long {
        var low = 0L
        val temp = (d[0].toLong() + d[1].toLong()) * maxOf(r[0], r[1]).toLong()
        var high = maxOf(100L, temp)
        while (low <= high) {
            val mid = low + (high - low) / 2
            val x1 = mid - mid / r[0]
            val x2 = mid - mid / r[1]
            val gcdd = gcd(r[0].toLong(), r[1].toLong())
            val x = (r[0] / gcdd) * r[1].toLong()
            val x3 = mid - (mid / r[0] + mid / r[1] - mid / x)
            if (x1 >= d[0] && x2 >= d[1] && x1 + x2 - x3 >= d[0].toLong() + d[1])
                high = mid - 1
            else
                low = mid + 1
        }
        return low
    }
}
