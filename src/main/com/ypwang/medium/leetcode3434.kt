package com.ypwang.medium

class Solution3434 {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        val cnt = IntArray(51)
        var rst = 0
        var cntK = 0
        for (n in nums) {
            cnt[n] = maxOf(cnt[n], cntK) + 1
            if (n == k) {
                rst++
                cntK++
            }

            rst = maxOf(rst, cnt[n])
        }
        return rst
    }
}
