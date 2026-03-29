package com.ypwang.easy

class Solution3884 {
    fun firstMatchingIndex(s: String): Int {
        for (i in 0 until (s.length + 1) / 2) {
            if (s[i] == s[s.length-1-i])
                return i
        }
        return -1
    }
}
