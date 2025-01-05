package com.ypwang.hard

class Solution3414 {
    fun maximumWeight(intervals: List<List<Int>>): IntArray {
        val seen = mutableMapOf<List<Int>, Int>()
        for ((index, element) in intervals.withIndex())
            seen.putIfAbsent(element, index)

        val sorted = seen.keys.sortedBy { it[0] }

        // Memoization map for dp
        val dpCache = mutableMapOf<Pair<Int, Int>, Pair<Long, IntArray>>()

        // Helper function to implement the dp with memoization
        fun dp(i: Int, k: Int): Pair<Long, IntArray> {
            if (k == 0 || i == sorted.size)
                return Pair(0, intArrayOf())

            // Check cache first
            return dpCache.getOrPut(i to k) {
                // Skip case
                val skip = dp(i + 1, k)

                // Pick case
                // Find the first index in sorted where r+1 is greater than the current l
                val j = sorted.indexOfFirst { it[0] > sorted[i][1] }.takeIf { it >= 0 } ?: sorted.size
                val pick0 = dp(j, k - 1)
                val pick =
                    Pair(pick0.first - sorted[i][2], (pick0.second + intArrayOf(seen[sorted[i]]!!)).apply { sort() })

                // Take the minimum between skipping and picking
                minOf(skip, pick, compareBy<Pair<Long, IntArray>> { it.first }.thenComparator { o1, o2 ->
                    o1.second.zip(o2.second).firstOrNull { it.first != it.second }.let {
                        it?.first?.compareTo(it.second) ?: o1.second.size.compareTo(o2.second.size)
                    }
                })
            }
        }

        return dp(0, 4).second
    }
}
