package com.ypwang.medium

class Solution3976 {
    fun div(x: Long, k: Int): Long =
        if (x >= 0)
            x / k
        else
            -((-x) / k)

    fun op(x: Long, k: Int, flag: Long): Long =
        if (flag != 0L) x * k
        else div(x, k)

    fun f(v: IntArray, k: Int, flag: Long): Long {
        val inf = 1e18.toLong()
        val n = v.size
        val dp1 = LongArray(n)
        val dp2 = LongArray(n)
        val dp3 = LongArray(n)

        dp1[0] = v[0].toLong()
        dp2[0] = op(v[0].toLong(), k, flag)
        dp3[0] = -inf

        for (i in 1 until n) {
            val `val` = op(v[i].toLong(), k, flag)
            dp1[i] = maxOf(v[i].toLong(), dp1[i - 1] + v[i])
            dp2[i] = maxOf(`val`, maxOf(dp1[i - 1] + `val`, dp2[i - 1] + `val`))
            dp3[i] = maxOf(dp2[i - 1] + v[i], maxOf(dp3[i - 1] + v[i], dp2[i]))
        }

        var ans = -inf
        for (i in 0 until n)
            ans = maxOf(ans, dp1[i], dp2[i], dp3[i])
        return ans
    }

    fun maxSubarraySum(nums: IntArray, k: Int): Long =
        maxOf(f(nums, k, 0), f(nums, k, 1))
}
