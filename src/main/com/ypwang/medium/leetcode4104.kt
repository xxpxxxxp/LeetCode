package com.ypwang.medium

class Solution4104 {
    fun countValidSubstrings(s: String): Long {
        val n = s.length

        var lastA = -1
        var lastAB = -1
        var left = 0

        var res = 0L

        for (right in 0 until n) {
            val ch = s[right]

            if (ch == 'a')
                lastA = right
            else if (ch == 'b' && lastA != -1)
                lastAB = lastA
            else if (ch == 'c' && lastAB != -1)
                left = maxOf(left, lastAB + 1)

            res += (right - left + 1).toLong()
        }

        return res
    }
}
