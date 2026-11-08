package com.ypwang.easy

class Solution4102 {
    fun countValidSubstrings(s: String): Long {
        val parts = s.replace("abc", "ab bc").split(" ").dropLastWhile { it.isEmpty() }.toTypedArray()
        var res = -(parts.size - 1).toLong()
        for (p in parts) {
            val n = p.length.toLong()
            res += n * (n + 1) / 2
        }
        return res
    }
}
