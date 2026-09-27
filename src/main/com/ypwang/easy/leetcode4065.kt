package com.ypwang.easy

class Solution4065 {
    fun rearrangeArray(nums: IntArray): IntArray {
        val d = nums.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val rst = mutableListOf<Int>()
        while (d.isNotEmpty()) {
            for ((k, v) in d.toList().sortedBy { it.first }) {
                rst.add(k)
                if (v == 1)
                    d.remove(k)
                else
                    d[k] = v - 1
            }
        }

        return rst.toIntArray()
    }
}
