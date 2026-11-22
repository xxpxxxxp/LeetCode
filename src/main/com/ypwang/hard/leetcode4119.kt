package com.ypwang.hard

class Solution4119 {
    private var best = 0

    private fun dfs(masks: IntArray, chosenMask: Int, usedBits: Int) {
        if (usedBits >= best)
            return

        var firstUncov = -1
        for (i in masks.indices) {
            if ((masks[i] and chosenMask) == 0) {
                firstUncov = i
                break
            }
        }

        if (firstUncov == -1) {
            best = usedBits
            return
        }

        val cand = masks[firstUncov]
        var bestBit = 0
        var bestGain = 0

        for (j in 0..30) {
            val bit = 1 shl j
            if ((cand and bit) != 0) {
                var gain = 0
                for (i in firstUncov until masks.size) {
                    if ((masks[i] and chosenMask) == 0 && (masks[i] and bit) != 0) {
                        gain++
                    }
                }
                if (gain > bestGain) {
                    bestGain = gain
                    bestBit = bit
                }
            }
        }

        if (bestBit != 0)
            dfs(masks, chosenMask or bestBit, usedBits + 1)

        for (j in 0..30) {
            val bit = 1 shl j
            if ((cand and bit) != 0 && bit != bestBit) {
                dfs(masks, chosenMask or bit, usedBits + 1)
            }
        }
    }

    fun minSetBits(nums: IntArray, k: Int): Int {
        val n = nums.size
        val m = n - k + 1
        if (m <= 0)
            return -1

        val lastZero = IntArray(31) { -1 }
        val masks = IntArray(m)

        for (i in 0 until n) {
            for (j in 0..30)
                if (((nums[i] shr j) and 1) == 0)
                    lastZero[j] = i

            if (i >= k - 1) {
                val start = i - k + 1
                var x = 0
                for (j in 0..30)
                    if (lastZero[j] < start)
                        x = x or (1 shl j)

                if (x == 0) return -1
                masks[start] = x
            }
        }

        best = 32
        dfs(masks, 0, 0)
        return if (best >= 32) -1 else best
    }
}
