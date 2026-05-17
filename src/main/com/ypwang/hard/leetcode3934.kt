package com.ypwang.hard

class Solution3934 {
    fun smallestUniqueSubarray(nums: IntArray): Int {
        val n = nums.size
        val b = 215215L
        val mod = (1L shl 31) - 1
        var l = 1
        var r = n
        while (l < r) {
            val k = (l + r) / 2
            var h = 0L
            var p = 1L
            for (i in 0 until k) {
                h = (h * b + nums[i]) % mod
                p = (p * b) % mod
            }
            val c = mutableMapOf(h to 1)
            for (i in k until n) {
                h = (h * b + nums[i] - (nums[i - k] * p) % mod) % mod
                if (h < 0)
                    h += mod
                c[h] = c.getOrDefault(h, 0) + 1
            }
            var found = false
            for (`val` in c.values) {
                if (`val` == 1) {
                    found = true
                    break
                }
            }
            if (found)
                r = k
            else
                l = k + 1
        }

        return l
    }
}
