package com.ypwang.hard

class Solution3883 {
    val M = 1000000007

    fun countArrays(digitSum: IntArray): Int {
        val g = Array(51) { mutableListOf<Int>() }

        for (i in 0..5000)
            g[i.toString().map { it - '0' }.sum()].add(i)

        val n = digitSum.size

        if (g[digitSum[0]].isEmpty())
            return 0

        var dp = LongArray(g[digitSum[0]].size) { 1 }

        for (i in 1 until n) {
            val p = g[digitSum[i - 1]]
            val c = g[digitSum[i]]

            if (c.isEmpty())
                return 0

            val pre = LongArray(p.size)
            pre[0] = dp[0]
            for (j in 1 until p.size)
                pre[j] = (pre[j - 1] + dp[j]) % M

            var k = 0

            val nd = LongArray(c.size)
            for (j in c.indices) {
                while (k < p.size && p[k] <= c[j])
                    k++
                if (k > 0)
                    nd[j] = pre[k - 1]
            }

            dp = nd
        }

        return dp.fold(0L) { acc, i -> (acc + i) % M }.toInt()
    }
}
