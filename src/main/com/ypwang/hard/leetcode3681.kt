package com.ypwang.hard

class Solution3681 {
    fun maxXorSubsequences(nums: IntArray): Int {
        val n = nums.size
        if (n == 0)
            return 0
        var x = 0

        while (true) {
            val y = nums.max()

            if (y == 0)
                return x

            x = maxOf(x, x xor y)

            for (i in 0 until n)
                nums[i] = minOf(nums[i], nums[i] xor y)
        }
    }
}
