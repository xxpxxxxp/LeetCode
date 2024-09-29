package com.ypwang.medium

class Solution3301 {
    fun maximumTotalSum(maximumHeight: IntArray): Long {
        maximumHeight.sortDescending()

        var rst = 0L
        var cur = Int.MAX_VALUE
        for (h in maximumHeight) {
            cur = minOf(cur-1, h)
            if (cur <= 0)
                return -1L

            rst += cur
        }

        return rst
    }
}
