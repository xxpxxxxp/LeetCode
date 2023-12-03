package com.ypwang.medium

class Solution2953 {
    fun countCompleteSubstrings(word: String, k: Int): Int {
        fun calc(s: String): Int {
            var rst = 0
            val n = s.length
            for (i in 1..26) {
                if (i * k > n)
                    break

                val l = i * k
                val cnt = mutableMapOf<Char, Int>()
                for (j in 0 until l)
                    cnt[s[j]] = cnt.getOrDefault(s[j], 0) + 1

                val freq = mutableMapOf<Int, Int>()
                for (c in cnt.values)
                    freq[c] = freq.getOrDefault(c, 0) + 1

                if (freq.getOrDefault(k, 0) == i)
                    rst++

                for (idx in 0 until n - l) {
                    // - s[idx]
                    val preC = cnt[s[idx]]!!
                    cnt[s[idx]] = preC - 1
                    freq[preC] = freq[preC]!! - 1
                    freq[preC-1] = freq.getOrDefault(preC-1, 0) + 1

                    // + s[idx+l]
                    val preCL = cnt.getOrDefault(s[idx+l], 0)
                    if (preCL in freq)
                        freq[preCL] = freq[preCL]!! - 1
                    cnt[s[idx+l]] = preCL + 1
                    freq[preCL+1] = freq.getOrDefault(preCL+1, 0) + 1

                    if (freq.getOrDefault(k, 0) == i)
                        rst++
                }
            }

            return rst
        }

        var idx = 0
        var rst = 0
        val n = word.length
        for (i in 1 until n) {
            if (Math.abs(word[i] - word[i-1]) > 2) {
                rst += calc(word.substring(idx, i))
                idx = i
            }
        }
        rst += calc(word.substring(idx))
        return rst
    }
}