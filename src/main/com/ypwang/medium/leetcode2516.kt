package com.ypwang.medium

class Solution2516 {
    fun takeCharacters(s: String, k: Int): Int {
        val cnt = intArrayOf(0, 0, 0)
        var rst = 0
        var idx = -1
        for ((i, c) in s.withIndex().reversed()) {
            cnt[c - 'a']++
            if (cnt.all { it >= k }) {
                idx = i
                rst = s.length - i
                break
            }
        }

        if (idx == -1)
            return -1

        var j = 0
        for (i in idx until s.length) {
            cnt[s[i] - 'a']--
            while (j < s.length && cnt.any { it < k }) {
                cnt[s[j++] - 'a']++
            }

            if (j == s.length)
                break

            rst = minOf(rst, j + s.length - i - 1)
        }

        return rst
    }
}

fun main() {
    println(Solution2516().takeCharacters("aabaaaacaabc", 2))
    println(Solution2516().takeCharacters("a", 1))
}