package com.ypwang.medium


class Solution2554 {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        var maxSum = maxSum
        val set = banned.toSet()
        var count = 0
        for (i in 1..n) {
            if (i in set)
                continue
            if (i <= maxSum) {
                maxSum -= i
                count++
            } else
                break
        }
        return count
    }
}