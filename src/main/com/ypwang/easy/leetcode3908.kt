package com.ypwang.easy

class Solution3908 {
    fun validDigit(n: Int, x: Int): Boolean {
        val t = n.toString()
        val c = '0' + x
        return t.contains(c) && !t.startsWith(c)
    }
}
