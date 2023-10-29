package com.ypwang.easy

class Solution2913 {
    fun sumCounts(nums: List<Int>): Int {
        var rst = 0
        val set = mutableSetOf<Int>()
        for (i in nums.indices) {
            set.clear()
            for (j in i until nums.size) {
                set.add(nums[j])
                rst += set.size * set.size
            }
        }
        return rst
    }
}