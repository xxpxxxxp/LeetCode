package com.ypwang.easy

class Solution3471 {
    fun largestInteger(nums: IntArray, k: Int): Int {
        if (k == 1)
            return nums
                .groupBy { it }
                .filter { it.value.size == 1 }
                .map { it.key }
                .maxOrNull() ?: -1

        if (k == nums.size)
            return nums.max()

        val a = nums.first()
        val b = nums.last()
        val ca = nums.count { it == a }
        val cb = nums.count { it == b }

        if (ca == 1 && cb == 1)
            return maxOf(a, b)

        if (ca == 1)
            return a

        if (cb == 1)
            return b

        return -1
    }
}
