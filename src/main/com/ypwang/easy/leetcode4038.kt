package com.ypwang.easy

class Solution4038 {
    fun countSpecialIntegers(nums: IntArray): Int {
        val cnt = IntArray(101)
        var res = 0
        for (i in nums.indices)
            if (i == 0 || nums[i] != nums[i - 1])
                cnt[nums[i]]++
        for (c in cnt)
            if (c == 1)
                res++
        return res
    }
}
