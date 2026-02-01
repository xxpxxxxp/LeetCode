package com.ypwang.easy

class Solution3827 {
    fun countMonobit(n: Int): Int {
        var i = 0
        var j = 0
        while (j <= n) {
            j = (j shl 1) + 1
            i++
        }

        return i
    }
}
