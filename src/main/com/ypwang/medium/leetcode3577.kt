package com.ypwang.medium

class Solution3577 {
    fun countPermutations(complexity: IntArray): Int {
        val mod = 1000000007
        val n = complexity.size
        var rst = 1L

        for (i in 1 until n) {
            if (complexity[i] <= complexity[0])
                return 0

            rst *= i
            rst %= mod
        }

        return rst.toInt()
    }
}
