package com.ypwang.easy

class Solution3707 {
    fun scoreBalance(s: String): Boolean {
        val score = s.map { it - 'a' + 1 }.sum()
        if (score % 2 == 1)
            return false

        var i = 0
        var cur = 0
        while (i < s.lastIndex) {
            cur += s[i] - 'a' + 1
            if (2 * cur == score)
                return true
            i++
        }

        return false
    }
}
