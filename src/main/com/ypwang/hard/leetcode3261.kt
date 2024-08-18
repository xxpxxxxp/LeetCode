package com.ypwang.hard

class Solution3261 {
    fun countKConstraintSubstrings(s: String, k: Int, queries: Array<IntArray>): LongArray {
        val n = s.length
        val a = LongArray(n)
        val pre = LongArray(n + 1)
        var left = 0
        var count0 = 0
        var count1 = 0

        for (right in 0 until n) {
            if (s[right] == '1')
                count1++
            else
                count0++
            while (count0 > k && count1 > k) {
                if (s[left] == '1')
                    count1--
                else
                    count0--
                left++
            }
            a[right] = (right - left + 1).toLong()
        }

        for (i in 0 until n)
            pre[i + 1] = pre[i] + a[i]

        return queries.map {
            val (l, r) = it
            var cur = 0L
            var len = 0
            for (i in l..r) {
                len++
                if (a[i] <= len) {
                    cur += pre[r + 1] - pre[i]
                    break
                } else {
                    cur += len
                }
            }
            cur
        }.toLongArray()
    }
}
