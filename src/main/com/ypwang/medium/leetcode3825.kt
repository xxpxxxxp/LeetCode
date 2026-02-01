package com.ypwang.medium

class Solution3825 {
    private fun lis(nums: List<Int>): Int {
        val res = mutableListOf<Int>()

        for (x in nums) {
            if (res.isEmpty() || res.last() < x) {
                res.add(x)
            } else {
                // lower_bound equivalent
                var idx = res.binarySearch(x)
                if (idx < 0) idx = -idx - 1
                res[idx] = x
            }
        }

        return res.size
    }

    fun longestSubsequence(nums: IntArray): Int {
        var best = 0

        for (i in 0 until 31) {
            val curr = mutableListOf<Int>()

            for (x in nums)
                if ((x and (1 shl i)) != 0)
                    curr.add(x)

            best = maxOf(best, lis(curr))
        }

        return best
    }
}
