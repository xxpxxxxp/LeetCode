package com.ypwang.hard

class Solution4064 {
    fun longestSubarray(nums: IntArray, k: Int): Int {
        val n = nums.size
        val prefix = IntArray(n + 1)
        for (i in 0 until n)
            prefix[i + 1] = Math.floorMod(prefix[i] + nums[i], k)

        val first = IntArray(k) { n + 1 }
        val last = IntArray(k) { -1 }
        for (i in 0..n)
            last[prefix[i]] = i
        for (i in n downTo 0)
            first[prefix[i]] = i

        var best = 0
        for (c in 0 until k)
            best = maxOf(best, last[c] - first[c]) // no negation

        val doubled = IntArray(n)
        for (i in 0 until n)
            doubled[i] = Math.floorMod(2 * nums[i], k)

        val nxt = IntArray(k) { n + 1 }
        var i = n - 1
        for ((j, c) in first.withIndex().sortedByDescending { it.value }) {
            if (c > n)
                continue

            while (i >= c) {
                nxt[doubled[i]] = i
                i--
            }
            for (v in 0 until k) {
                val end = last[(j + v) % k]
                if (nxt[v] < end)
                    best = maxOf(best, end - c)
            }
        }

        return best
    }
}
