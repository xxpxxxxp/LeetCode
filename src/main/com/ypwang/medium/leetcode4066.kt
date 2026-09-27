package com.ypwang.medium

class Solution4066 {
    fun maxEqualAdjacentPairs(nums: IntArray): Int {
        val n = nums.size
        var basePairs = 0
        val pairCount = mutableMapOf<Long, Int>()
        var maxNewPairs = 0

        for (i in 0 until n - 1) {
            if (nums[i] == nums[i + 1])
                basePairs++
            else {
                val u = minOf(nums[i], nums[i + 1])
                val v = maxOf(nums[i], nums[i + 1])
                val key = (u.toLong() shl 32) or (v.toLong() and 0xFFFFFFFFL)

                val count = pairCount.getOrDefault(key, 0) + 1
                pairCount[key] = count
                if (count > maxNewPairs)
                    maxNewPairs = count
            }
        }

        return basePairs + maxNewPairs
    }
}
