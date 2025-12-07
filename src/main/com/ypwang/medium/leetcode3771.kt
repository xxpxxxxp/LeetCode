package com.ypwang.medium

class Solution3771 {
    fun totalScore(hp: Int, damage: IntArray, requirement: IntArray): Long {
        val n = damage.size
        val S = LongArray(n + 1)
        for (i in 1..n)
            S[i] = S[i - 1] + damage[i - 1]

        var ans = 0L
        for (i in 1..n) {
            val T = S[i] + requirement[i - 1] - hp.toLong()
            val k = lowerBound(S, T)
            if (k <= i - 1)
                ans += i - k
        }
        return ans
    }

    private fun lowerBound(a: LongArray, x: Long): Int {
        var l = 0
        var r = a.size - 1
        while (l < r) {
            val m = (l + r) / 2
            if (a[m] >= x)
                r = m
            else
                l = m + 1
        }
        return l
    }
}

fun main() {
    println(Solution3771().totalScore(3, intArrayOf(1,1), intArrayOf(2,1)))
}