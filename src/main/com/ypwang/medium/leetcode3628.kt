package com.ypwang.medium

class Solution3628 {
    fun numOfSubsequences(s: String): Long {
        val n = s.length
        val prefix = LongArray(n + 1) // `L` count (1-based)
        val suffix = LongArray(n + 1) // `T` count (0-based)

        // Build prefix array for `L`
        for (i in 0 until n) {
            if (s[i] == 'L')
                prefix[i + 1] = 1
            prefix[i + 1] += prefix[i]
        }

        // Build suffix array for `T`
        for (i in n - 1 downTo 0) {
            if (s[i] == 'T')
                suffix[i] = 1
            suffix[i] += suffix[i + 1]
        }

        var resWithC = 0L
        var bestPosForC = 0L
        var resWithL = 0L
        var resWithT = 0L

        for (i in 0 until n) {
            if (s[i] == 'C') {
                resWithC += prefix[i] * suffix[i + 1]
                resWithL += (prefix[i] + 1) * suffix[i + 1]
                resWithT += prefix[i] * (suffix[i + 1] + 1)
            } else {
                bestPosForC = maxOf(prefix[i] * suffix[i], bestPosForC)
            }
        }

        resWithC += bestPosForC
        return maxOf(resWithL, resWithT, resWithC)
    }
}
