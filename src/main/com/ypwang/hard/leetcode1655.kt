package com.ypwang.hard

class Solution1655 {
    fun canDistribute(nums: IntArray, quantity: IntArray): Boolean {
        val occ = nums.groupBy { it }.map { it.value.size }.toIntArray()
        val take = quantity.sortedDescending()

        fun solve(i: Int): Boolean {
            if (i == take.size)
                return true

            val q = take[i]
            for ((j, v) in occ.withIndex()) {
                if (v >= q) {
                    occ[j] -= q

                    if (solve(i+1))
                        return true

                    occ[j] += q
                }
            }

            return false
        }

        return solve(0)
    }
}