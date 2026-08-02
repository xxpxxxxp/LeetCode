package com.ypwang.easy

class Solution4010 {
    fun gcd(a: Int, b: Int): Int =
        if (a == 0) b else gcd(b % a, a)

    fun maxPairStrength(nums: IntArray): Long {
        var max = 0L
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val ans = gcd(nums[i], nums[j])
                val square = ans.toLong() * ans
                val res = (nums[i].toLong() * nums[j]) / square
                max = maxOf(res, max)
            }
        }
        return max
    }
}
