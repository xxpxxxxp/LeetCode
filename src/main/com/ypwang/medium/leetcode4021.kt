package com.ypwang.medium

class Solution4021 {
    fun minOperations(s: String): Int {
        val n = s.length
        var res = n * 20
        for (i in 0 until n) {
            var cur = i
            for (j in 0 until n / 2) {
                val a = s[(i + j) % n].code
                val b = s[(i - j - 1 + n) % n].code
                val d = Math.abs(a - b)
                cur += minOf(d, 26 - d)
                if (cur > res)
                    break
            }
            res = minOf(res, cur)
        }
        return res
    }
}
