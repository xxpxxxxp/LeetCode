package com.ypwang.easy

class Solution2124 {
    fun checkString(s: String): Boolean {
        var vb = s.indexOf('b')
        if (vb == -1)
            vb = Int.MAX_VALUE

        val va = s.lastIndexOf('a')
        return va < vb
    }
}