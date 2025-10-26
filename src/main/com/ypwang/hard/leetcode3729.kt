package com.ypwang.hard

class Solution3729 {
    fun numGoodSubarrays(nums: IntArray, k: Int): Long {
        var ans = 0L
        val ps = LongArray(nums.size + 1)
        for (i in nums.indices)
            ps[i + 1] = nums[i] + ps[i]

        val map = mutableMapOf(0L to 1L)
        for (i in nums.indices) {
            val key = ps[i + 1] % k
            val t = map.getOrDefault(key, 0L)
            ans += t
            map[key] = t + 1L
        }

        val map2 = mutableMapOf<String, Long>()
        for (i in nums.indices) {
            val key = (ps[i + 1] % k).toString() + "#" + nums[i].toString()
            val t = map2.getOrDefault(key, 0L)
            ans -= t
            map2[key] = t + 1L
        }
        return ans
    }
}
