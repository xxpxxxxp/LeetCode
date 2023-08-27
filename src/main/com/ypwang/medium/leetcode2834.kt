package com.ypwang.medium

class Solution2834 {
    fun minimumPossibleSum(n: Int, target: Int): Long {
        val seen = mutableSetOf<Int>()
        var rst  = 0L
        var i = 1
        while (seen.size < n) {
            if (target - i !in seen) {
                seen.add(i)
                rst += i
            }
            ++i
        }
        return rst
    }
}