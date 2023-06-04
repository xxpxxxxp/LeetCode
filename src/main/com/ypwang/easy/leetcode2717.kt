package com.ypwang.easy

class Solution2717 {
    fun semiOrderedPermutation(nums: IntArray): Int {
        val i1 = nums.indices.single { nums[it] == 1 }
        val i2 = nums.indices.single { nums[it] == nums.size }
        val rst = i1 + nums.size - 1 - i2
        if (i2 < i1)
            return rst - 1
        return rst
    }
}