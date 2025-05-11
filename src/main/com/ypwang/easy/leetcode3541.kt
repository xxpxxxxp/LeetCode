package com.ypwang.easy

class Solution3541 {
    fun maxFreqSum(s: String): Int {
        val freq = IntArray(26)
        s.forEach { freq[it - 'a']++ }
        var v = 0
        var n = 0
        for (i in freq.indices) {
            if ('a' + i in setOf('a', 'e', 'i', 'o', 'u'))
                v = maxOf(v, freq[i])
            else
                n = maxOf(n, freq[i])
        }

        return v + n
    }
}
