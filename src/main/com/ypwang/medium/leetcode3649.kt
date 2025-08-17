package com.ypwang.medium

class Solution3649 {
    fun perfectPairs(nums: IntArray): Long {
        for ((i, v) in nums.withIndex())
            nums[i] = Math.abs(v)

        nums.sort()

        var cnt = 0L
        var r = 0
        for (i in 0 until nums.size) {
            if (r < i)
                r = i
            while (r + 1 < nums.size && nums[r + 1] <= 2 * nums[i])
                r++

            cnt += r - i
        }
        return cnt
    }
}
