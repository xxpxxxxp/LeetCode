package com.ypwang.medium

import kotlin.math.pow

class Solution4022 {
    fun kthDigit(k: Long): Int {
        var k = k
        var l = 1
        while (l * 9L * 10.0.pow((l - 1).toDouble()) < k) {
            k -= (l * 9L * 10.0.pow((l - 1).toDouble())).toLong()
            l += 1
        }
        k -= 1
        val d = 10.0.pow((l - 1).toDouble()).toLong() + k / l
        k %= l
        val res = d.toString()[k.toInt()] - '0'
        return if (k < l - 1 || d / 10 % 2 == 0L) res else 9 - res
    }
}
