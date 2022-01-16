package com.ypwang.easy

class Solution2138 {
    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        var i = 0
        val rst = mutableListOf<String>()
        while (i < s.length) {
            var p = s.substring(i, minOf(i+k, s.length))
            if (p.length < k)
                p = p.padEnd(k, fill)
            rst.add(p)
            i += k
        }

        return rst.toTypedArray()
    }
}