package com.ypwang.medium

class Solution1894 {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var left = k.toLong() % (chalk.fold(0L) { acc, i -> acc + i })

        for ((i, v) in chalk.withIndex()) {
            if (left < v)
                return i

            left -= v
        }

        return 0
    }
}