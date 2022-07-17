package com.ypwang.medium

class Solution2342 {
    fun maximumSum(nums: IntArray): Int =
        nums.groupBy {
            var c = 0
            var i = it
            while (i > 0) {
                c += i % 10
                i /= 10
            }
            c
        }.map { if (it.value.size >= 2) it.value.sortedDescending().take(2).sum() else -1 }.maxOrNull()!!
}