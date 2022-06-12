package com.ypwang.medium

class Solution2300 {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        potions.sort()
        val rst = IntArray(spells.size)
        var idx = 0
        for ((i, v) in spells.withIndex().sortedByDescending { it.value }) {
            val l = v.toLong()
            while (idx < potions.size && l * potions[idx] < success)
                idx++

            rst[i] = potions.size - idx
        }

        return rst
    }
}