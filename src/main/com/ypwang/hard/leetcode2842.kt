package com.ypwang.hard

class Solution2842 {
    fun countKSubsequencesWithMaxBeauty(s: String, k: Int): Int {
        var k = k
        val count = IntArray(26)
        for (c in s)
            count[c - 'a']++

        count.sort()
        if (k > 26 || count[26 - k] == 0)
            return 0
        var res = 1L
        var comb = 1L
        val mod = 1000000007
        val bar = count[26 - k].toLong()
        var pend = 0L
        for (freq in count) {
            if (freq > bar) {
                k--
                res = res * freq % mod
            }
            if (freq.toLong() == bar)
                pend++
        }
        for (i in 0 until k) {
            comb = comb * (pend - i) / (i + 1)
            res = res * bar % mod
        }
        return (res * comb % mod).toInt()
    }
}