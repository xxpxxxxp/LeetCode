package com.ypwang.easy

class Solution2243 {
    fun digitSum(s: String, k: Int): String {
        var s = s
        val sb = StringBuilder()
        var i = 0
        while (s.length > k) {
            sb.clear()
            i = 0
            while (i < s.length) {
                val sub = s.substring(i, minOf(i+k, s.length))
                sb.append(sub.map { it - '0' }.sum().toString())
                i += k
            }
            s = sb.toString()
        }
        return s
    }
}