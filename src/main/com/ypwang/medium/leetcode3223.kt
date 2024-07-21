package com.ypwang.medium

class Solution3223 {
    fun minimumLength(s: String): Int {
        val c = IntArray(26)
        s.forEach { c[it - 'a']++ }
        return c.map {
            if (it == 0)
                0
            else if (it % 2 == 0)
                2
            else
                1
        }.sum()!!
    }
}
