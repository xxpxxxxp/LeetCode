package com.ypwang.medium

class Solution3788 {
    fun maximumScore(nums: IntArray): Long {
        var suff = nums.last()
        var pre = nums.fold(0L) { a, b -> a + b } - suff
        var rst = pre - suff

        for (i in nums.lastIndex-1 downTo 1) {
            pre -= nums[i]
            suff = minOf(suff, nums[i])
            rst = maxOf(rst, pre - suff)
        }

        return rst
    }
}
