package com.ypwang.medium

class Solution3804 {
    fun centeredSubarrays(nums: IntArray): Int {
        var rst = 0
        for (d in 0 until nums.size) {
            var e = 0
            val f = mutableSetOf<Int>()
            for (g in d until nums.size) {
                e += nums[g]
                f.add(nums[g])
                if (e in f)
                    rst++
            }
        }
        return rst
    }
}
