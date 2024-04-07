package com.ypwang.hard

class Solution2223 {
    private fun z_function(s: String): Long {
        val z = IntArray(s.length)
        var l = 0
        var r = 0
        for (i in 1 until s.length) {
            if (i <= r)
                z[i] = minOf(r - i + 1, z[i-l])

            while (i + z[i] < s.length && s[z[i]] == s[i + z[i]])
                z[i]++

            if (i + z[i] - 1 > r) {
                l = i
                r = i + z[i] - 1
            }
        }

        return z.fold(0L){ a, b -> a + b }
    }

    fun sumScores(s: String): Long = z_function(s) + s.length
}