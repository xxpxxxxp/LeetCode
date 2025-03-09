package com.ypwang.hard

class Solution3480 {
    fun maxSubarrays(n: Int, conflictingPairs: Array<IntArray>): Long {
        val right = Array(n + 1) { mutableListOf<Int>() }
        for ((a, b) in conflictingPairs) {
            right[maxOf(a, b)].add(minOf(a, b))
        }

        var ans = 0L
        var left = IntArray(2)
        val imp = IntArray(n + 1)

        for (r in 1..n) {
            for (l in right[r]) {
                left = maxOf(
                    left,
                    intArrayOf(l, left[0]),
                    intArrayOf(left[0], l),
                    compareBy<IntArray> { it[0] }.thenBy { it[1] }
                )
            }
            ans += r - left[0]
            imp[left[0]] += left[0] - left[1]
        }

        return ans + imp.max()
    }
}
