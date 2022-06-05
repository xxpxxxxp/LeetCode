package com.ypwang.easy

class Solution2293 {
    fun minMaxGame(nums: IntArray): Int {
        var len = nums.size
        while (len > 1) {
            for (i in 0 until len / 2) {
                if (i % 2 == 0)
                    nums[i] = minOf(nums[2 * i], nums[2 * i + 1])
                else
                    nums[i] = maxOf(nums[2 * i], nums[2 * i + 1])
            }

            len /= 2
        }

        return nums.first()
    }
}