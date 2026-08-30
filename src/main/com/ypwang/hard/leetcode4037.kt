package com.ypwang.hard

class Solution4037 {
    fun solve(skip: Int, a: IntArray): Int {
        val n = a.size
        val pre = IntArray(n + 1)
        val suff = IntArray(n + 1)
        for (i in 1..n) {
            if (i - 1 == skip) {
                pre[i] = pre[i - 1]
                continue
            }
            pre[i] = gcd(pre[i - 1], a[i - 1])
        }
        for (i in n - 1 downTo 0) {
            if (i == skip) {
                suff[i] = suff[i + 1]
                continue
            }
            suff[i] = gcd(suff[i + 1], a[i])
        }
        var curr = 0
        for (i in 0 until n - 1) {
            if (i == skip)
                continue
            if (pre[i + 1] == suff[i + 1]) curr++
        }
        return curr
    }

    private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)

    fun maxValidSplits(nums: IntArray): Int {
        val n = nums.size
        var ans = 0
        val premain = IntArray(n + 1)
        val suffmain = IntArray(n + 1)
        for (i in 1..n)
            premain[i] = gcd(premain[i - 1], nums[i - 1])
        for (i in n - 1 downTo 0)
            suffmain[i] = gcd(suffmain[i + 1], nums[i])
        for (i in 0..n) {
            if (i > 0 && premain[i] == premain[i - 1])
                continue
            ans = maxOf(ans, solve(i - 1, nums))
        }
        for (i in n - 1 downTo 0) {
            if (suffmain[i] == suffmain[i + 1])
                continue
            ans = maxOf(ans, solve(i - 1, nums))
        }
        return ans
    }
}
