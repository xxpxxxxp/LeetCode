package com.ypwang.easy

class Solution3880 {
    fun minAbsoluteDifference(nums: IntArray): Int {
        var rst = 10000
        var pos1 = -1
        var pos2 = -1
        for (i in nums.indices) {
            if (nums[i] == 1) {
                pos1 = i
                if (pos2 != -1)
                    rst = minOf(rst, pos1 - pos2)
            } else if (nums[i] == 2) {
                pos2 = i
                if (pos1 != -1)
                    rst = minOf(rst, pos2 - pos1)
            }
        }

        return if (rst == 10000) -1 else rst
    }
}
