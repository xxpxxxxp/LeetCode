package com.ypwang.medium

class Solution3371 {
    fun getLargestOutlier(nums: IntArray): Int {
        val sum = nums.sum()!!
        val set = nums.groupBy { it }.map { it.key to it.value.size }.toMap()
        var rst = Int.MIN_VALUE
        for ((n, v) in set) {
            val d = sum - n
            if (d % 2 == 0 && (d / 2) in set)
                if (d / 2 != n || v > 1)
                    rst = maxOf(rst, n)
        }

        return rst
    }
}
