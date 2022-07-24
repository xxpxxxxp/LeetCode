package com.ypwang.hard

class Solution2350 {
    fun shortestSequence(A: IntArray, k: Int): Int {
        var res = 1
        val s = mutableSetOf<Int>()
        for (a in A) {
            s.add(a)
            if (s.size == k) {
                res++
                s.clear()
            }
        }
        return res
    }
}