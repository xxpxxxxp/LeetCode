package com.ypwang.medium

class Solution4067 {
    fun maxSubarray(nums: IntArray): Int {
        val freq = IntArray(501)

        var l = 0
        var ans = 0

        for (r in nums.indices) {
            val x = nums[r]

            while (isInvalid(x, freq)) {
                freq[nums[l]]--
                l++
            }

            freq[x]++
            ans = maxOf(ans, r - l + 1)
        }

        return ans
    }

    private fun isInvalid(x: Int, freq: IntArray): Boolean {
        for (a in 1..x / 2) {
            val b = x - a

            if (freq[a] > 0 && freq[b] > 0) {
                if (a == b) {
                    if (freq[a] >= 2)
                        return true
                } else
                    return true
            }
        }

        var a = 1
        while (a + x <= 500) {
            val b = x + a

            if (freq[a] > 0 && freq[b] > 0)
                return true
            a++
        }

        return false
    }
}
