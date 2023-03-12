package com.ypwang.medium

class Solution2587 {
    fun maxScore(nums: IntArray): Int {
        val (pos, neg) = nums.partition { it > 0 }
        var sum = pos.fold(0L) { a, b -> a + b }
        var rst = pos.size

        for (v in neg.sortedDescending()) {
            sum += v
            if (sum > 0L)
                rst++
            else
                break
        }

        return rst
    }
}