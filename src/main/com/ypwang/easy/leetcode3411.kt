package com.ypwang.easy

class Solution3411 {
    fun maxLength(nums: IntArray): Int {
        val n = nums.size
        var maxLen = 1
        for (i in 0 until n) {
            var pro = nums[i]
            var gcd = nums[i]
            var lcm = nums[i]
            for (j in i + 1 until n) {
                gcd = gcd(gcd, nums[j])
                pro *= nums[j]
                lcm = lcm(lcm, nums[j])
                if (lcm * gcd == pro) {
                    maxLen = maxOf(maxLen, j - i + 1)
                }
            }
        }
        return maxLen
    }

    private fun lcm(a: Int, b: Int): Int =
        (a * b) / gcd(a, b)

    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val temp = b
            b = a % b
            a = temp
        }
        return a
    }
}
