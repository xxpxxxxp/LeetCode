package com.ypwang.hard

class Solution2963 {
    fun numberOfGoodPartitions(nums: IntArray): Int {
        var res = 1
        val n = nums.size
        val mod = 1000000007
        val last = mutableMapOf<Int, Int>()
        for (i in 0 until n)
            last[nums[i]] = i

        var i = 0
        var j = 0
        while (i < n) {
            if (i > j)
                res = res * 2 % mod

            j = maxOf(j, last[nums[i]]!!)
            i++
        }
        return res
    }
}