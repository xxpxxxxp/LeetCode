package com.ypwang.medium

class Solution2470 {
    private fun gcd(a: Int, b: Int): Int {
        if (a == 0) return b
        return gcd(b % a, a)
    }

    fun subarrayLCM(nums: IntArray, k: Int): Int {
        var count = 0
        for (i in nums.indices) {
            var lcm = 1
            for (j in i until nums.size) {
                if (k % nums[j] != 0)
                    break

                lcm = lcm * nums[j] / gcd(lcm, nums[j])
                if (lcm == k)
                    count++
            }
        }

        return count
    }
}