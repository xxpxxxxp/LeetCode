package com.ypwang.easy

class Solution1995 {
    fun countQuadruplets(nums: IntArray): Int {
        var rst = 0

        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                for (k in j+1 until nums.size) {
                    for (l in k+1 until nums.size) {
                        if (nums[i] + nums[j] + nums[k] == nums[l])
                            rst++
                    }
                }
            }
        }

        return rst
    }
}