package com.ypwang.easy

class Solution2917 {
    fun findKOr(nums: IntArray, k: Int): Int {
        val c = IntArray(31)
        for (n in nums) {
            for (i in 0 until 31) {
                if (n and (1 shl i) > 0)
                    c[i]++
            }
        }

        return c.withIndex().filter { it.value >= k }.map { it.index }.fold(0) { cur, i -> cur or (1 shl i) }
    }
}