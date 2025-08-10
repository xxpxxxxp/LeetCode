package com.ypwang.medium

class Solution3644 {
    fun sortPermutation(nums: IntArray): Int {
        val n = nums.size
        val pos = IntArray(n)

        for (i in 0..<n)
            pos[nums[i]] = i

        var minn = Int.MAX_VALUE
        for (i in 0 until n) {
            if (nums[i] == i)
                continue
            val p = pos[i]
            minn = minn and nums[i] and nums[p]
        }

        return if (minn == Int.MAX_VALUE) 0 else minn
    }
}
