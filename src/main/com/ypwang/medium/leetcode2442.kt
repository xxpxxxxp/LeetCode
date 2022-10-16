package com.ypwang.medium

class Solution2442 {
    private fun reverse(n: Int): Int {
        var n = n
        var rst = 0
        while (n > 0) {
            rst = rst * 10 + n % 10
            n /= 10
        }
        return rst
    }

    fun countDistinctIntegers(nums: IntArray): Int {
        val set = mutableSetOf<Int>()

        for (n in nums) {
            set.add(n)
            set.add(reverse(n))
        }

        return set.size
    }
}