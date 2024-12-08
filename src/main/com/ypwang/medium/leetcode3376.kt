package com.ypwang.medium

class Solution3376 {
    fun findMinimumTime(strength: List<Int>, K: Int): Int {
        fun f(mask: Int, x: Int, time: Int): Int {
            if (mask == 0)
                return time

            var rst = Int.MAX_VALUE
            for (i in strength.indices) {
                if (mask and (1 shl i) == 0)
                    continue

                rst = minOf(rst, f(mask xor (1 shl i), x + K, time + (strength[i] + x - 1) / x))
            }

            return rst
        }

        return f((1 shl strength.size) - 1, 1, 0)
    }
}
