package com.ypwang.hard

class Solution1739 {
    fun minimumBoxes(n: Int): Int {
        var cur = 0
        var i = 0
        var j = 0
        while (cur < n) {
            i += ++j
            cur += i
        }

        if (cur == n)
            return i

        cur -= i
        i -= j
        j = 0
        while (cur < n) {
            cur += ++j
        }

        return i+j
    }
}