package com.ypwang.medium

class Solution1362 {
    fun closestDivisors(num: Int): IntArray {
        val x = num + 1
        val y = num + 2

        for (i in Math.sqrt(y.toDouble()).toInt() downTo 1) {
            if (x % i == 0) return intArrayOf(x / i, i)
            if (y % i == 0) return intArrayOf(y / i, i)
        }

        return intArrayOf(1, x)
    }
}