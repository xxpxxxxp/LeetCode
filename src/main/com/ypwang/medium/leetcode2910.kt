package com.ypwang.medium

class Solution2910 {
    fun minGroupsForValidAssignment(nums: IntArray): Int {
        val count = nums.groupBy { it }.map { it.value.size }.sorted().toIntArray()

        if (count.size == 1)
            return 1

        outer@ for (i in count.first() downTo 1) {
            var c = 0
            for (v in count) {
                if (v % i > v / i)
                    continue@outer

                c += Math.ceil(v / (i+1).toDouble()).toInt()
            }

            return c
        }

        return 1
    }
}