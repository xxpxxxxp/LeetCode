package com.ypwang.hard

import kotlin.math.log2

class Solution2835 {
    fun minOperations(nums: List<Int>, target: Int): Int {
        val count = IntArray(32)
        for (n in nums)
            count[log2(n.toDouble()).toInt()]++

        var j = 32
        var ops = 0
        for (i in 0 until 31) {
            if (target and (1 shl i) > 0) {
                if (count[i] > 0)
                    --count[i]
                else
                    j = minOf(j, i)
            }
            if (count[i] > 0 && j < i) {
                --count[i]
                ops += i - j
                j = 32
            }
            count[i+1] += count[i] / 2
        }

        return if (j < 32) -1 else ops
    }
}