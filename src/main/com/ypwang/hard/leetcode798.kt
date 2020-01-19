package com.ypwang.hard

class Solution798 {
    fun bestRotation(A: IntArray): Int {
        val bad = IntArray(A.size)
        for ((i, v) in A.withIndex()) {
            val left = (i - v + 1 + A.size) % A.size
            val right = (i + 1) % A.size
            bad[left]--
            bad[right]++
            if (left > right) bad[0]--
        }

        var best = Int.MIN_VALUE
        var ans = 0
        var cur = 0
        for (i in A.indices) {
            cur += bad[i]
            if (cur > best) {
                best = cur
                ans = i
            }
        }

        return ans
    }
}