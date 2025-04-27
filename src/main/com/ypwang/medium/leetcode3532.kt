package com.ypwang.medium

class Solution3532 {
    fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): BooleanArray {
        val g = IntArray(n)
        for (i in 1..<n)
            g[i] = g[i - 1] + (if ((nums[i] - nums[i - 1]) > maxDiff) 1 else 0)

        return queries.map { (a, b) -> g[a] == g[b] }.toBooleanArray()
    }
}
