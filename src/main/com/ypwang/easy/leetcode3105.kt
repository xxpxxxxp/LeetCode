package com.ypwang.easy

class Solution3105 {
    fun longestMonotonicSubarray(nums: IntArray): Int =
        maxOf(helper(nums, compareBy { it }), helper(nums, compareByDescending { it }))

    private fun helper(nums: IntArray, comparator: Comparator<Int>): Int {
        var i = 0
        var j = 0
        var rst = 0

        while (j+1 < nums.size) {
            while (j + 1 < nums.size && comparator.compare(nums[j], nums[j+1]) < 0)
                j++

            rst = maxOf(j+1-i, rst)
            i = ++j
        }

        return maxOf(j+1-i, rst)
    }
}
