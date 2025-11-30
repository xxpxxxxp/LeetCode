package com.ypwang.medium

class Solution3761 {
    private fun reverse(a: Int): Int {
        var a = a
        var b = 0
        while (a > 0) {
            b = b * 10 + a % 10
            a /= 10
        }
        return b
    }

    fun minMirrorPairDistance(nums: IntArray): Int {
        val pre = mutableMapOf<Int, Int>()
        val n = nums.size
        var res = n
        for (i in n - 1 downTo 0) {
            val b = reverse(nums[i])
            if (b in pre)
                res = minOf(res, pre[b]!! - i)
            pre[nums[i]] = i
        }

        return if (res < n) res else -1
    }
}
