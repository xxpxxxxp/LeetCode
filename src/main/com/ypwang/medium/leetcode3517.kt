package com.ypwang.medium

class Solution3517 {
    fun smallestPalindrome(s: String): String {
        val count = IntArray(26)
        for (c in s)
            count[c-'a']++

        var rst = CharArray(s.length)
        var idx = 0
        for (i in 0 until 26) {
            val c = count[i]
            if (c == 0)
                continue

            for (j in 0 until c/2) {
                rst[idx] = 'a' + i
                rst[s.length-1-idx] = 'a' + i
                idx++
            }

            if (c % 2 != 0)
                rst[s.length/2] = 'a' + i
        }

        return String(rst)
    }
}
