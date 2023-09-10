package com.ypwang.easy

class Solution2843 {
    fun countSymmetricIntegers(low: Int, high: Int): Int =
        (low..high).count { symmetric(it) }

    fun symmetric(n: Int): Boolean {
        val s = n.toString()
        val len = s.length
        if (len % 2 == 1)
            return false
        val mid = len / 2
        var s1 = 0
        var s2 = 0
        for (i in 0 until mid) {
            s1 += s[i] - '0'
            s2 += s[len - i - 1] - '0'
        }
        return s1 == s2
    }
}