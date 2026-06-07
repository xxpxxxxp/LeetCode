package com.ypwang.easy

class Solution3950 {
    fun consecutiveSetBits(n: Int): Boolean {
        val s = n.toString(2)
        val idx = s.indexOf("11")
        return idx >= 0 && s.indexOf("11", idx+1) == -1
    }
}
