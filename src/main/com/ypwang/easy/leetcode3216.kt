package com.ypwang.easy

class Solution3216 {
    fun getSmallestString(s: String): String {
        val c = s.toCharArray()
        for (i in 0 until c.lastIndex) {
            if (c[i] > c[i+1] && (c[i] - '0') % 2 == (c[i+1] - '0') % 2) {
                val t = c[i]
                c[i] = c[i+1]
                c[i+1] = t
                break
            }
        }

        return String(c)
    }
}
