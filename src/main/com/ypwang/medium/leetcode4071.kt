package com.ypwang.medium

class Solution4071 {
    fun dist(a: Char, b: Char): Int =
        minOf(Math.abs(a - b), 10 - Math.abs(a - b))

    fun minRotations(n: Int, s: String): Int {
        val pref = IntArray(n)
        val suf = IntArray(n)

        pref[0] = dist('0', s[0])

        for (i in 1 until n)
            pref[i] = pref[i - 1] + dist(s[i - 1], s[i])

        for (i in n - 2 downTo 0)
            suf[i] = suf[i + 1] + dist(s[i], s[i + 1])

        var mn = pref[n - 1]

        for (k in 0 until n) {
            val cur = if (k == 0)
                dist('0', s[n - 1]) + suf[0]
            else
                (pref[k - 1]
                        + dist(s[k - 1], s[n - 1])
                        + suf[k])

            mn = minOf(mn, cur)
        }

        return mn
    }
}
