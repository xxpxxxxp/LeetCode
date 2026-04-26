package com.ypwang.medium

class Solution3909 {
    fun compareBitonicSums(nums: IntArray): Int {
        val sum = nums.fold(0L) { a, b -> a + b }

        var i = 1
        var c = nums[0].toLong()
        while (i < nums.size && nums[i-1] < nums[i]) {
            c += nums[i]
            i++
        }

        return if (c > sum - c + nums[i-1]) 0 else if (c < sum - c + nums[i-1]) 1 else -1
    }
}
