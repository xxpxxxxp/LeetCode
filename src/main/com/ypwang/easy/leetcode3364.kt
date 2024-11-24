package com.ypwang.easy

class Solution3364 {
    fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int {
        val size = nums.size
        var res = -1
        for (s in l..r) {
            for (i in 0..size - s) {
                var sum = 0
                for (j in i until i + s) {
                    sum += nums[j]
                }
                if (sum > 0) {
                    if (res == -1 || res > sum) res = sum
                }
            }
        }
        return res
    }
}
