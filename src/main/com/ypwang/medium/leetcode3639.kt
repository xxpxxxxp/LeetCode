package com.ypwang.medium

import java.util.TreeSet

class Solution3639 {
    fun minTime(s: String, order: IntArray, k: Int): Int {
        var ans = 0L
        val set = TreeSet<Int>()
        val n = order.size
        set.add(-1)
        set.add(n)
        for ((i, curr) in order.withIndex()) {
            val left = set.lower(curr)!!.toLong()
            val right = set.higher(curr)!!.toLong()
            set.add(curr)
            ans += (curr - left) * (right - curr)
            if (ans >= k)
                return i
        }
        return -1
    }
}
