package com.ypwang.easy

class Solution2239 {
    fun findClosestNumber(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        val ls = mutableSetOf<Int>()
        for (n in nums) {
            val t = Math.abs(n)
            if (t == min) {
                ls.add(n)
            } else if (t < min) {
                ls.clear()
                min = t
                ls.add(n)
            }
        }

        return ls.maxOrNull()!!
    }
}