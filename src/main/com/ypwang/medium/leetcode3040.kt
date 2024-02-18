package com.ypwang.medium

class Solution3040 {
    fun maxOperations(nums: IntArray): Int {
        fun dfs(lo: Int, hi: Int, score: Int, cache: MutableMap<String, Int>): Int {
            if (hi <= lo)
                return 0

            val key = "$lo,$hi"
            if (key !in cache) {
                var max = 0
                if (score == nums[lo] + nums[lo + 1])
                    max = maxOf(max, 1 + dfs(lo + 2, hi, score, cache))
                if (score == nums[lo] + nums[hi])
                    max = maxOf(max, 1 + dfs(lo + 1, hi - 1, score, cache))
                if (score == nums[hi - 1] + nums[hi])
                    max = maxOf(max, 1 + dfs(lo, hi - 2, score, cache))
                cache[key] = max
            }
            return cache[key]!!
        }

        var rst = 0
        val n = nums.size
        for (score in setOf(nums[0] + nums[1], nums[0] + nums[n - 1], nums[n - 2] + nums[n - 1]))
            rst = maxOf(rst, dfs(0, n - 1, score, mutableMapOf()))
        return rst
    }
}

fun main() {
    println(Solution3040().maxOperations(intArrayOf(2,2,1,2,1)))
}