package com.ypwang.medium

class Solution2447 {
    private fun gcd(a: Int, b: Int): Int =
        if (a == 0) b else gcd(b % a, a)

    fun subarrayGCD(nums: IntArray, k: Int): Int {
        var rst = 0
        for (i in nums.indices) {
            var g = nums[i]
            for (j in i until nums.size) {
                g = gcd(g, nums[j])
                if (g == k)
                    rst++
                else if (g % k != 0)
                    break
            }
        }
        return rst
    }
}
