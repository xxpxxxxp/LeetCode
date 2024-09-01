package com.ypwang.medium

class Solution3271 {
    fun stringHash(s: String, k: Int): String =
        String(CharArray(s.length / k) { i ->
            'a' + (i * k until (i+1) * k)
                .map { s[it] - 'a' }
                .sum() % 26
        })
}
