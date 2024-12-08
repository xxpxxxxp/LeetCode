package com.ypwang.easy

class Solution3375 {
    fun minOperations(nums: IntArray, k: Int): Int {
        val t = nums.toSet()
        if (t.min() < k)
            return -1

        return t.count { it > k }
    }
}
