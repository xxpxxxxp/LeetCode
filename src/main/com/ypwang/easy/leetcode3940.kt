package com.ypwang.easy

class Solution3940 {
    fun limitOccurrences(nums: IntArray, k: Int): IntArray {
        var cur = Int.MIN_VALUE
        var count = 0

        val rst = mutableListOf<Int>()

        for (n in nums) {
            if (cur != n) {
                cur = n
                count = 1
            } else {
                if (count >= k)
                    continue

                count++
            }

            rst.add(n)
        }

        return rst.toIntArray()
    }
}
