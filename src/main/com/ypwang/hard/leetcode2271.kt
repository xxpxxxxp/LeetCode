package com.ypwang.hard

class Solution2272 {
    fun largestVariance(s: String): Int {
        val freq = Array(s.length) { IntArray(26) }
        val currFreq = IntArray(26)
        for ((i, c) in s.withIndex()) {
            currFreq[c - 'a']++
            freq[i] = currFreq.clone()
        }

        var maxVariance = 0
        // a => char with minimum frequency
        // b => char with maximum frequency
        for (a in 0..25) {
            for (b in 0..25) {
                if (a == b || freq[s.length - 1][a] == 0 || freq[s.length - 1][b] == 0)
                    continue

                var aFreq = 0
                var bFreq = 0
                for ((i, c) in s.withIndex()) {
                    val j = c - 'a'
                    if (j == b)
                        bFreq++
                    if (j == a)
                        aFreq++

                    if (aFreq > 0)
                        maxVariance = maxOf(maxVariance, bFreq - aFreq)

                    if (bFreq < aFreq && freq[s.length - 1][a] - freq[i][a] != 0) {
                        aFreq = 0
                        bFreq = 0
                    }
                }
            }
        }

        return maxVariance
    }
}