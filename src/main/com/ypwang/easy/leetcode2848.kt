package com.ypwang.easy

class Solution2848 {
    fun numberOfPoints(nums: List<List<Int>>): Int {
        val nums = nums.sortedBy { it[0] }

        var rst = 0
        var start = -1
        for ((b, e) in nums) {
            var s = maxOf(start, b)
            if (e >= s)
                rst += (e - s + 1)

            start = maxOf(start, e + 1)
        }

        return rst
    }
}
