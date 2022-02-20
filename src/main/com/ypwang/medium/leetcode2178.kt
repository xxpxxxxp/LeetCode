package com.ypwang.medium

class Solution2178 {
    fun maximumEvenSplit(finalSum: Long): List<Long> {
        if (finalSum % 2 != 0L)
            return listOf()

        var i = 2L
        var sum = 0L
        val rst = mutableListOf<Long>()
        while (i + sum <= finalSum) {
            rst.add(i)
            sum += i
            i += 2
        }

        rst[rst.lastIndex] = rst[rst.lastIndex] + (finalSum - sum)
        return rst
    }
}