package com.ypwang.medium

import kotlin.math.sqrt

class Solution3233 {
    fun nonSpecialCount(l: Int, r: Int): Int {
        val limit = sqrt(r.toDouble()).toInt()
        val notPrime = BooleanArray(limit + 1)

        var p = 2
        while (p * p <= limit) {
            if (!notPrime[p]) {
                var i = p * p
                while (i <= limit) {
                    notPrime[i] = true
                    i += p
                }
            }
            p++
        }

        var special = 0
        var i = 2
        var last = 4
        while (last <= r) {
            if (!notPrime[i] && last >= l)
                special++
            i++
            last = i * i
        }

        return (r - l + 1) - special
    }
}
