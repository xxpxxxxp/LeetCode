package com.ypwang.easy

class Solution3379 {
    fun constructTransformedArray(nums: IntArray): IntArray =
        IntArray(nums.size) { i ->
            val n = nums[i]
            if (n > 0) {
                nums[(i + n) % nums.size]
            } else if (n < 0) {
                nums[(i + nums.size - (-n % nums.size)) % nums.size]
            } else
                0
        }
}
