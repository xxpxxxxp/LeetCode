package com.ypwang.medium

class Solution1726 {
    fun tupleSameProduct(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var rst = 0
        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                val mul = nums[i] * nums[j]
                val pre = map.getOrDefault(mul, 0)
                rst += 8 * pre
                map[mul] = pre + 1
            }
        }

        return rst
    }
}