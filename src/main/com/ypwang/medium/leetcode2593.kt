package com.ypwang.medium

class Solution2593 {
    fun findScore(nums: IntArray): Long {
        val seen = BooleanArray(nums.size)
        var rst = 0L

        for ((i, n) in nums.withIndex().sortedBy { it.value }) {
            if (!seen[i]) {
                rst += n
                seen[i] = true
                if (i > 0)
                    seen[i-1] = true
                if (i+1 < nums.size)
                    seen[i+1] = true
            }
        }
        return rst
    }
}