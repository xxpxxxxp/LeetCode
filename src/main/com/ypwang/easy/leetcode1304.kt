package com.ypwang.easy

class Solution1304 {
    fun sumZero(n: Int): IntArray {
        val rst = IntArray(n)
        var c = 500
        var i = 0
        var j = n-1
        while (i < j) {
            rst[i] = -c
            rst[j] = c
            c--
            i++
            j--
        }
        return rst
    }
}