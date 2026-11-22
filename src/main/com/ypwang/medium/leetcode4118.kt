package com.ypwang.medium

class Solution4118 {
    val INF = 100000000
    
    private fun build(b: IntArray, m: Int): Array<IntArray> {
        val n = b.size
        val f = Array(n) { IntArray(m + 1) }
        for (i in 0 until n) {
            f[i][0] = INF
            for (v in 1..m) {
                val prev = if (i > 0) f[i - 1][v - 1] else 0
                f[i][v] = minOf(f[i][v - 1], prev + Math.abs(b[i] - v))
            }
        }
        return f
    }

    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        if (n < 3)
            return -1

        val maxVal = nums.max()
        val m = maxVal + n

        val l = build(nums, m)
        val r = build(nums.reversed().toIntArray(), m)

        var ans = INF
        for (i in 1 until n - 1)
            for (v in 1..m)
                ans = minOf(ans, l[i - 1][v - 1] + r[n - 2 - i][v - 1] + Math.abs(nums[i] - v))

        return ans
    }
}
