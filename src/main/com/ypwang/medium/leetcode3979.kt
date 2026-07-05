package com.ypwang.medium

class Solution3979 {
    fun maxValidPairSum(nums: IntArray, k: Int): Int {
        var res = 0
        for (i in nums.indices) {
            if (i >= k)
                res = maxOf(res, nums[i] + nums[i - k])

            if (i > 0)
                nums[i] = maxOf(nums[i], nums[i - 1])
        }
        return res
    }
}
