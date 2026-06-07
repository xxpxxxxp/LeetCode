package com.ypwang.medium

class Solution3952 {
    fun maxTotal(nums: IntArray, s: String): Long {
        var ans = 0L
        var i = 0

        while (i < nums.size && s[i] == '1') {
            ans += nums[i].toLong()
            i++
        }

        while (i < nums.size) {
            if (s[i] == '1') {
                var csm = nums[i - 1].toLong()
                var mn = nums[i - 1]

                while (i < nums.size && s[i] == '1') {
                    csm += nums[i].toLong()
                    mn = minOf(mn, nums[i])
                    i++
                }

                ans += csm - mn
            } else
                i++
        }

        return ans
    }
}
