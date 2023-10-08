package com.ypwang.hard

class Solution2987 {
    fun maxSum(nums: List<Int>, k: Int): Int {
        val count = IntArray(32)
        var res = 0L
        for (a in nums)
            for (i in 0..31)
                if (a and (1 shl i) != 0) count[i]++
        for (j in 0 until k) {
            var cur = 0L
            for (i in 0..31) {
                if (count[i] > 0) {
                    count[i]--
                    cur += 1 shl i
                }
            }
            res = (res + cur * cur % 1000000007) % 1000000007
        }
        return res.toInt()
    }
}