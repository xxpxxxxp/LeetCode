package com.ypwang.medium

class Solution3780 {
    fun maximumSum(nums: IntArray): Int {
        val l0 = mutableListOf<Int>()
        val l1 = mutableListOf<Int>()
        val l2 = mutableListOf<Int>()
        for (v in nums) {
            when (v % 3) {
                0 -> l0.add(v)
                1 -> l1.add(v)
                2 -> l2.add(v)
            }
        }

        var ans = 0

        l0.sortDescending()
        l1.sortDescending()
        l2.sortDescending()
        if (l0.size >= 3)
            ans = maxOf(ans, l0.take(3).sum())
        if (l1.size >= 3)
            ans = maxOf(ans, l1.take(3).sum())
        if (l2.size >= 3)
            ans = maxOf(ans, l2.take(3).sum())
        if (l0.isNotEmpty() && l1.isNotEmpty() && l2.isNotEmpty())
            ans = maxOf(ans, l0.first() + l1.first() + l2.first())
        return ans
    }
}
