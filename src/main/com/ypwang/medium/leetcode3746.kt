package com.ypwang.medium

class Solution3746 {
    fun minLengthAfterRemovals(s: String): Int {
        val c = s.count { it == 'a' }
        return s.length - 2 * minOf(c, s.length - c)
    }
}
