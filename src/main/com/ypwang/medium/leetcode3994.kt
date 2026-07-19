package com.ypwang.medium

class Solution3994 {
    fun minAdjacentSwaps(nums: IntArray, a: Int, b: Int): Int {
        val MOD = 1000000007
        var count1 = 0L
        var count2 = 0L
        var res = 0L
        for (num in nums) {
            if (num < a)
                res += (count1 + count2)
            else if (num <= b) {
                res += count2
                count1++
            } else
                count2++
        }
        return (res % MOD).toInt()
    }
}
