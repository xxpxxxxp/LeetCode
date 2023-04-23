package com.ypwang.medium

class Solution2654 {
    private fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)
    fun minOperations(nums: IntArray): Int {
        val c = nums.count { it == 1 }
        if (c > 0)
            return nums.size - c

        var min = Int.MAX_VALUE
        for (i in nums.indices) {
            var g = nums[i]
            for (j in i+1 until nums.size) {
                g = gcd(g, nums[j])
                if (g == 1) {
                    min = minOf(min, j-i+nums.size-1)
                    break
                }
            }
            if (min == Int.MAX_VALUE)
                return -1
        }
        return min
    }
}
