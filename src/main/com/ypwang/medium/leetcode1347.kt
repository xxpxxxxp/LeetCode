package com.ypwang.medium

class Solution1347 {
    fun minSteps(s: String, t: String): Int {
        val si = IntArray(26)
        for (c in s)
            si[c - 'a']++

        for (c in t)
            si[c - 'a']--

        return si.filter { it > 0 }.sum()
    }
}