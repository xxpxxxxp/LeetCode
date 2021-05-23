package com.ypwang.hard

class Solution1872 {
    fun stoneGameVIII(stones: IntArray): Int {
        val sum = IntArray(stones.size + 1)
        for ((i, v) in stones.withIndex()) {
            sum[i+1] = sum[i] + v
        }

        return (stones.lastIndex-1 downTo 1).fold(sum.last()) { acc, i ->
            maxOf(acc, sum[i+1] - acc)
        }
    }
}