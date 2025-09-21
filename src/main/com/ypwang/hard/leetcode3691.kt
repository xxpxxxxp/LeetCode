package com.ypwang.hard

import java.util.TreeSet

class SparseTable(a: IntArray) {
    private val n: Int = a.size
    private val mn: Array<IntArray>
    private val mx: Array<IntArray>
    private val logVal: IntArray

    init {
        val maxLog = 32 - Integer.numberOfLeadingZeros(n)

        mn = Array(n) { IntArray(maxLog) }
        mx = Array(n) { IntArray(maxLog) }
        logVal = IntArray(n + 1)

        for (i in 2..n) {
            logVal[i] = logVal[i / 2] + 1
        }

        for (i in 0 until n) {
            mn[i][0] = a[i]
            mx[i][0] = a[i]
        }

        for (j in 1 until maxLog) {
            var i = 0
            while (i + (1 shl j) <= n) {
                mn[i][j] = minOf(mn[i][j - 1], mn[i + (1 shl (j - 1))][j - 1])
                i++
            }
        }

        for (j in 1 until maxLog) {
            var i = 0
            while (i + (1 shl j) <= n) {
                mx[i][j] = maxOf(mx[i][j - 1], mx[i + (1 shl (j - 1))][j - 1])
                i++
            }
        }
    }

    fun queryMin(l: Int, r: Int): Int {
        val j = logVal[r - l + 1]
        return minOf(mn[l][j], mn[r - (1 shl j) + 1][j])
    }

    fun queryMax(l: Int, r: Int): Int {
        val j = logVal[r - l + 1]
        return maxOf(mx[l][j], mx[r - (1 shl j) + 1][j])
    }
}

class Solution3691 {
    fun maxTotalValue(nums: IntArray, k: Int): Long {
        var ans = 0L
        val st = SparseTable(nums)
        val n = nums.size

        // use TreeSet with comparator to mimic C++ multiset of pairs
        val s = TreeSet(compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }.thenBy { it.third })

        for (i in 0 until n)
            s.add(Triple(st.queryMax(0, i) - st.queryMin(0, i), 0, i))

        var remaining = k
        while (remaining > 0 && s.isNotEmpty()) {
            val (x, l, r) = s.pollLast()!!

            if (l + 1 <= r)
                s.add(Triple(st.queryMax(l + 1, r) - st.queryMin(l + 1, r), l + 1, r))

            ans += x
            remaining--
        }

        return ans
    }
}
