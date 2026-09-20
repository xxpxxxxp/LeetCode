package com.ypwang.medium

class Solution4053 {
    fun minOperations(nums: IntArray): Long {
        var res = 0L
        val P = Array(2) { mutableListOf<Long>() }

        val M = 1000000000L
        for (v in 1..99999) {
            val s = v.toString()
            val r = StringBuilder(s).reverse().toString()
            val a1 = (s.substring(0, s.length - 1) + r).toLong()
            val a2 = (s + r).toLong()
            if (a1 < M)
                P[(a1 and 1L).toInt()].add(a1)
            if (a2 < M)
                P[(a2 and 1L).toInt()].add(a2)
        }
        P[0].sort()
        P[1].sort()

        for (a in nums) {
            val p = P[a and 1]
            var i = p.binarySearch(a.toLong())
            if (i < 0)
                i = -(i + 1)
            if (i >= p.size)
                i = p.size - 1
            val d1 = Math.abs(a - p[i])
            val d2 = if (i > 0) Math.abs(a - p[i - 1]) else d1
            res += minOf(d1, d2) / 2
        }
        return res
    }
}
