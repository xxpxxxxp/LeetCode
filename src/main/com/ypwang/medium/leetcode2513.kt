package com.ypwang.medium

class Solution2513 {
    private fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)

    fun minimizeSet(divisor1: Int, divisor2: Int, uniqueCnt1: Int, uniqueCnt2: Int): Int {
        var lo = 0L
        var hi = Int.MAX_VALUE.toLong()
        val mult = divisor1.toLong() * divisor2 / gcd(divisor1, divisor2)
        while (lo < hi) {
            val mid = (lo + hi) / 2
            val cnt1 = mid - mid / divisor1
            val cnt2 = mid - mid / divisor2
            val ovlp = cnt1 - mid / divisor2 + mid / mult
            if (cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && maxOf(0L, uniqueCnt1 - cnt1 + ovlp) + maxOf(0L, uniqueCnt2 - cnt2 + ovlp) <= ovlp)
                hi = mid
            else
                lo = mid + 1
        }
        return lo.toInt()
    }
}