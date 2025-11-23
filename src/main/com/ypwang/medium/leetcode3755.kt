package com.ypwang.medium

class Solution3755 {
    fun maxBalancedSubarray(nums: IntArray): Int {
        val n = nums.size
        var balance = 0
        var xr = 0
        var res = 0

        // mp[xr][balance] = first index where (xr, balance) occurred
        val mp = mutableMapOf(0 to mutableMapOf(0 to -1))

        for (i in 0 until n) {
            xr = xr xor nums[i]
            balance += if ((nums[i] and 1) == 1) 1 else -1

            val inner = mp[xr]
            if (inner != null && balance in inner)
                res = maxOf(res, i - inner[balance]!!)
            else {
                if (inner == null)
                    mp[xr] = mutableMapOf(balance to i)
                else
                    inner[balance] = i
            }
        }

        return res
    }
}
