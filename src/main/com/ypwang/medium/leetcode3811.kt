package com.ypwang.medium

class Solution3811 {
    fun alternatingXOR(nums: IntArray, target1: Int, target2: Int): Int {
        val MOD = 1000000007

        val map1 = mutableMapOf<Int, Long>()
        val map2 = mutableMapOf<Int, Long>()

        var px = 0
        var dp1 = 0L
        var dp2 = 0L

        for (`val` in nums) {
            px = px xor `val`

            var curDp1 = map2.getOrDefault(px xor target1, 0L)
            if (px == target1) curDp1 = (curDp1 + 1) % MOD

            val curDp2 = map1.getOrDefault(px xor target2, 0L)

            // Update maps with new states
            map1[px] = (map1.getOrDefault(px, 0L) + curDp1) % MOD
            map2[px] = (map2.getOrDefault(px, 0L) + curDp2) % MOD

            dp1 = curDp1
            dp2 = curDp2
        }

        return ((dp1 + dp2) % MOD).toInt()
    }
}
