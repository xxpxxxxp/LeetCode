package com.ypwang.medium

class Solution2029 {
    fun stoneGameIX(stones: IntArray): Boolean {
        val mod = IntArray(3)
        stones.forEach { mod[it % 3]++ }
        val flip = mod[0] % 2 != 0
        if (mod[1] == 0)
            return mod[2] >= 3 && flip
        if (mod[2] == 0)
            return mod[1] >= 3 && flip
        return Math.abs(mod[1] - mod[2]) > 2 || !flip
    }
}