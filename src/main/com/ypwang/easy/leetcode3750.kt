package com.ypwang.easy

class Solution3750 {
    fun minimumFlips(n: Int): Int {
        val s = n.toString(2)
        val t = s.reversed()
        return s.zip(t).count { it.first != it.second }
    }
}
