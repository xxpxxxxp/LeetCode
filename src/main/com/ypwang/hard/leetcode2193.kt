package com.ypwang.hard

class Solution2193 {
    fun minMovesToMakePalindrome(s: String): Int {
        val l = s.toList().toMutableList()
        var rst = 0
        while (l.isNotEmpty()) {
            val i = l.indexOf(l.last())
            if (i == l.lastIndex)
                rst += i / 2
            else {
                rst += i
                l.removeAt(i)
            }
            l.removeAt(l.lastIndex)
        }

        return rst
    }
}