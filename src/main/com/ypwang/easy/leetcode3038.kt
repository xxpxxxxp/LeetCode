package com.ypwang.easy

class Solution3038 {
    fun maxOperations(nums: IntArray): Int {
        var sum = -1

        for (i in 0 until nums.size / 2) {
            val s = nums[i * 2] + nums[i * 2 + 1]
            if (i != 0 && s != sum)
                return i

            sum = s
        }

        return nums.size/2
    }
}