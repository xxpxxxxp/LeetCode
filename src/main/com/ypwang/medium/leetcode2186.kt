package com.ypwang.medium

class Solution2186 {
    fun minSteps(s: String, t: String): Int {
        val count = IntArray(26)
        for (c in s) {
            count[c - 'a']++
        }
        for (c in t) {
            count[c - 'a']--
        }
        return count.map { Math.abs(it) }.sum()
    }
}