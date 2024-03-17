package com.ypwang.hard

class Solution3086 {
    fun minimumMoves(nums: IntArray, k: Int, maxChanges: Int): Long {
        val A = mutableListOf(0L)
        for ((i, v) in nums.withIndex())
            if (v > 0)
                A.add(A.last() + i)

        val n = A.size - 1
        val m = maxOf(0, k - maxChanges)
        var res = Long.MAX_VALUE
        for (l in m..minOf(n, m + 3, k)) {
            for (i in 0..n - l) {
                val mid1 = i + l / 2
                val mid2 = i + l - l / 2
                res = minOf(res, A[i + l] - A[mid2] + A[i] - A[mid1] + (k - l) * 2)
            }
        }
        return res
    }
}
