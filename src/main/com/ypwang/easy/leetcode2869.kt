package com.ypwang.easy

class Solution2869 {
    fun minOperations(nums: List<Int>, k: Int): Int {
        val set = mutableSetOf<Int>()
        for ((i, n) in nums.reversed().withIndex()) {
            if (n in 1..k)
                set.add(n)
            if (set.size == k)
                return i + 1
        }
        return -1
    }
}