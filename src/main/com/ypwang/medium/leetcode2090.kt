package com.ypwang.medium

class Solution2090 {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        val rst = IntArray(nums.size) { -1 }

        var sum = nums.take(2 * k).fold(0L) { a, b -> a + b }
        for (i in k until nums.size) {
            if (i + k >= nums.size)
                break

            sum += nums[i+k]
            rst[i] = (sum / (2 * k + 1)).toInt()
            sum -= nums[i-k]
        }

        return rst
    }
}