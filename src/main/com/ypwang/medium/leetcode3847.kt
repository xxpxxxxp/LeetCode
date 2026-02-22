package com.ypwang.medium

class Solution3847 {
    fun scoreDifference(nums: IntArray): Int {
        val players = intArrayOf(0, 0)
        var active = 0

        for ((i, v) in nums.withIndex()) {
            if (((i+1) % 6 == 0) xor (v % 2 == 1))
                active = 1 - active

            players[active] += v
        }

        return players[0] - players[1]
    }
}
