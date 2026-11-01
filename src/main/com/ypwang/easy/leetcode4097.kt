package com.ypwang.easy

class Solution4097 {
    fun minMergedInteger(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        for (i in 0 until nums.size/2) {
            val t = nums[2*i].toString() + nums[2*i+1].toString()
            min = minOf(min, t.toInt())
        }

        return min
    }
}
