package com.ypwang.hard

import java.util.*

class Solution4051 {
    class BIT(var n: Int) {
        val tree = IntArray(n + 1)

        fun add(i: Int, v: Int) {
            var i = i
            while (i <= n) {
                tree[i] += v
                i += i and -i
            }
        }

        fun query(i: Int): Int {
            var i = i
            var r = 0
            while (i > 0) {
                r += tree[i]
                i -= i and -i
            }
            return r
        }
    }

    private fun upperBound(a: LongArray, len: Int, t: Long): Int {
        var l = 0
        var r = len
        while (l < r) {
            val m = l + (r - l) / 2
            if (a[m] <= t)
                l = m + 1
            else
                r = m
        }
        return l
    }

    private fun lowerBound(a: LongArray, len: Int, t: Long): Int {
        var l = 0
        var r = len
        while (l < r) {
            val m = l + (r - l) / 2
            if (a[m] < t)
                l = m + 1
            else
                r = m
        }
        return l
    }

    fun distantSubarrays(nums: IntArray, goal: Int, k: Int): Long {
        val n = nums.size
        if (k == 0)
            return n.toLong() * (n + 1) / 2

        val p = LongArray(n + 1)
        for (i in 0 until n)
            p[i + 1] = p[i] + nums[i]

        val s = p.clone()
        Arrays.sort(s)
        var m = 0
        for (i in s.indices)
            if (i == 0 || s[i] != s[i - 1])
                s[m++] = s[i]

        val bit = BIT(m)
        var res = 0L

        for ((tot, v) in p.withIndex()) {
            val idx1 = upperBound(s, m, v - goal - k)
            res += bit.query(idx1).toLong()

            val idx2 = lowerBound(s, m, v - goal + k)
            res += (tot - bit.query(idx2)).toLong()

            val idx = lowerBound(s, m, v) + 1
            bit.add(idx, 1)
        }

        return res
    }
}
