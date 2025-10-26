package com.ypwang.medium

class Solution3728 {
    fun countStableSubarrays(capacity: IntArray): Long {
        var ans = 0L
        var zeroCount = 0L
        val prefixSum = LongArray(capacity.size + 1)
        prefixSum[0] = 0
        for (i in capacity.indices) {
            prefixSum[i + 1] = prefixSum[i] + capacity[i]
            if (i > 0 && capacity[i] == 0 && capacity[i - 1] == 0)
                zeroCount++
        }
        val map = mutableMapOf<String, Long>()
        for (i in capacity.indices) {
            val key = (prefixSum[i] - capacity[i] * 2L).toString() + "#" + capacity[i].toString()
            ans += map.getOrDefault(key, 0L)
            val newKey = prefixSum[i].toString() + "#" + capacity[i].toString()
            map[newKey] = map.getOrDefault(newKey, 0L) + 1L
        }
        return ans - zeroCount
    }
}
