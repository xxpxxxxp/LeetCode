package com.ypwang.easy;

class Solution2006 {
    fun countKDifference(nums: IntArray, k: Int): Int {
        var rst = 0
        val cnt = mutableMapOf<Int, Int>()

        for (num in nums) {
            rst += cnt.getOrDefault(num, 0)
            cnt[num+k] = cnt.getOrDefault(num+k, 0) + 1
            cnt[num-k] = cnt.getOrDefault(num-k, 0) + 1
        }

        return rst
    }
}
