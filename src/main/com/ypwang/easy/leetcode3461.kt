package com.ypwang.easy

class Solution3461 {
    fun hasSameDigits(s: String): Boolean {
        var cs = s.map { it - '0' }
        while (cs.size > 2) {
            cs = (0 until cs.lastIndex).map {
                (cs[it] + cs[it+1]) % 10
            }
        }

        return cs[0] == cs[1]
    }
}
