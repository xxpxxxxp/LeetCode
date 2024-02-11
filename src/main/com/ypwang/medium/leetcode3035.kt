package com.ypwang.medium

class Solution3035 {
    fun maxPalindromesAfterOperations(words: Array<String>): Int {
        val cnt = IntArray(26)
        for (w in words)
            for (c in w)
                cnt[c-'a']++

        var pairs = cnt.map { it / 2 }.sum()

        var rst = 0
        for (l in words.map { it.length }.sorted()) {
            pairs -= l / 2
            if (pairs >= 0)
                rst++
        }

        return rst
    }
}
