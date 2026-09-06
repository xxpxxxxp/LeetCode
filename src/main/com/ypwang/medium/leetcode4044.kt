package com.ypwang.medium

class Solution4044 {
    fun countGoodRotations(nums: IntArray): Int {
        val n = nums.size
        var res = 0
        var cur = 0L
        for (i in 0 until n / 2)
            cur += (nums[i] - nums[i + n / 2]).toLong()

        for (i in 0 until n) {
            if (cur > 0)
                res += 1
            cur += ((nums[(i + n / 2) % n] - nums[i]) * 2).toLong()
        }
        return res
    }
}
