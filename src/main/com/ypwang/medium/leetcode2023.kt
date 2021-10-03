package com.ypwang.medium

class Solution2023 {
    fun numOfPairs(nums: Array<String>, target: String): Int {
        val map = nums.withIndex()
            .groupBy { it.value }
            .mapValues { it.value.size }

        return map.map { (str, c) ->
            if (target.startsWith(str)) {
                val follow = target.substring(str.length)
                if (follow == str)
                    c * (c-1)
                else
                    c * map.getOrDefault(follow, 0)
            } else
                0
        }.sum()
    }
}