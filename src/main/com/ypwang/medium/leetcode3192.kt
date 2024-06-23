package com.ypwang.medium

class Solution3192 {
    fun minOperations(nums: IntArray): Int {
        var cnt = false
        var rst = 0
        for (v in nums) {
            if (!((v == 1) xor cnt)) {
                rst++
                cnt = !cnt
            }
        }
        return rst
    }
}
