package com.ypwang.hard

class Solution2681 {
    fun sumOfPower(nums: IntArray): Int {
        nums.sort()
        var rst = 0L
        var s = 0L
        val base = 1000000007
        for (x in nums) {
            rst = (rst + (s + x) * x % base * x % base) % base
            s = (s * 2 + x) % base
        }
        return rst.toInt()
    }
}