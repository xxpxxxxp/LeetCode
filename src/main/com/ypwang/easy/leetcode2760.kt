package com.ypwang.easy

class Solution2760 {
    fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
        var cnt = 0
        var rst = 0

        for ((l, v) in nums.withIndex()) {
            if (v <= threshold) {
                if (cnt > 0) {
                    if (v % 2 != nums[l-1] % 2)
                        cnt++
                    else
                        cnt = 0
                }
                if (cnt == 0 && v % 2 == 0) {
                    cnt = 1
                }
                rst = maxOf(rst, cnt)
            } else {
                cnt = 0
            }
        }

        return rst
    }
}