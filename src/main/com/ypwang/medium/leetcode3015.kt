package com.ypwang.medium

class Solution3015 {
    fun countOfPairs(n: Int, x: Int, y: Int): IntArray {
        val ans = IntArray(n)
        for (i in 1..n) {
            for (j in i + 1..n) {
                val c = minOf(
                    Math.abs(i-j)-1,
                    minOf(
                        Math.abs(i-x) + Math.abs(y-j),
                        Math.abs(i-y) + Math.abs(x-j)
                    )
                )
                ans[c] += 2
            }
        }
        return ans
    }
}
