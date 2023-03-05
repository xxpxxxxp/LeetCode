package com.ypwang.easy

class Solution2582 {
    fun passThePillow(n: Int, time: Int): Int {
        val a = time / (n-1)
        val b = time % (n-1)
        if (a % 2 == 0)
            return b+1
        return n-b
    }
}