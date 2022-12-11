package com.ypwang.medium

class Solution2498 {
    fun maxJump(stones: IntArray): Int {
        var max = stones[1] - stones[0] // If n == 2
        for (i in 2 until stones.size)
            max = maxOf(max, stones[i] - stones[i - 2])
        return max
    }
}