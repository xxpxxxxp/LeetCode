package com.ypwang.medium

class Solution1573 {
    fun numWays(s: String): Int {
        var rst = 1L
        val count = s.count { it == '1' }

        if (count == 0)
            return if (s.length < 3) 0 else ((s.length-1L)*(s.length-2)/2 % 1000000007).toInt()

        if (count % 3 != 0)
            return 0

        var i = 0
        for (m in 0..1) {
            var ones = count / 3
            while (ones > 0) {
                if (s[i] == '1')
                    ones--

                i++
            }

            var j = i
            while (j < s.length && s[j] == '0') {
                j++
            }

            rst = (rst * (j - i + 1)) % 1000000007
        }

        return rst.toInt()
    }
}