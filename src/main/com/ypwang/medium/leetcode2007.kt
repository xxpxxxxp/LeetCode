package com.ypwang.medium

class Solution2007 {
    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.size % 2 == 1)
            return intArrayOf()

        changed.sort()
        val cnt = changed.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val rst = mutableListOf<Int>()

        for (c in changed) {
            if (cnt[c]!! > 0) {
                cnt[c] = cnt[c]!!-1
                if (cnt.getOrDefault(2 * c, 0) == 0)
                    return intArrayOf()

                rst.add(c)
                cnt[2 * c] = cnt[2 * c]!!-1
            }
        }

        return rst.toIntArray()
    }
}