package com.ypwang.medium

class Solution2915 {
    fun lengthOfLongestSubsequence(nums: List<Int>, target: Int): Int {
        val map = mutableMapOf(0 to 0)
        val keySet = sortedSetOf(0)

        for (n in nums) {
            val preKeys = keySet.descendingSet().toList()
            for (key in preKeys) {
                val nKey = key + n
                if (nKey <= target) {
                    map[nKey] = maxOf(map.getOrDefault(nKey, 0), map[key]!! + 1)
                    keySet.add(nKey)
                }
            }
        }

        return map.getOrDefault(target, -1)
    }
}