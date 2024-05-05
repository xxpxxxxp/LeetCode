package com.ypwang.medium

class Solution3138 {
    fun minAnagramLength(s: String): Int {
        fun test(k: Int): Boolean {
            val n = s.length
            val cnt = IntArray(26) { 0 }
            for (i in 0 until k)
                cnt[s[i] - 'a']++

            for (i in k until n step k) {
                val cnt2 = IntArray(26) { 0 }
                for (j in i until minOf(i + k, n))
                    cnt2[s[j] - 'a']++
                if (!cnt.contentEquals(cnt2))
                    return false
            }
            return true
        }

        return (1..s.length).first { s.length % it == 0 && test(it) }
    }
}
