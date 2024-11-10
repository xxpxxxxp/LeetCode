package com.ypwang.hard

class Solution3351 {
    fun sumOfGoodSubsequences(nums: IntArray): Int {
        val count = LongArray(100010)
        val total = LongArray(100010)
        val mod = 1000000007L
        var res = 0L
        for (a in nums) {
            count[a + 1] = (count[a] + count[a + 1] + count[a + 2] + 1) % mod
            val cur = total[a] + total[a + 2] + a.toLong() * (count[a] + count[a + 2] + 1)
            total[a + 1] = (total[a + 1] + cur) % mod
            res = (res + cur) % mod
        }
        return res.toInt()
    }
}
