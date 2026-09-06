package com.ypwang.easy

class Solution4043 {
    fun countRotations(s: String, k: Int): Int {
        val n = s.length

        if (n == 1)
            return if (k == 0) 1 else 0

        var total = 0
        for (i in 0 until n - 1)
            if (s[i] == s[i + 1])
                total++

        if (s[n - 1] == s[0])
            total++

        if (k == total)
            return n - total

        if (k == total - 1)
            return total

        return 0
    }
}
