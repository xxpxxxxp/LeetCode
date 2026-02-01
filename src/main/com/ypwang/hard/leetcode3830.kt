package com.ypwang.hard

class Solution3830 {
    fun longestAlternating(nums: IntArray): Int {
        val cmp = compareBy<Int> { it }
        val n = nums.size
        val l = IntArray(n) { 1 }
        for (i in 1 until n) {
            val d = cmp.compare(nums[i], nums[i - 1])
            if (d != 0) {
                if (i > 1 && cmp.compare(nums[i - 1], nums[i - 2]) == -d) l[i] = l[i - 1] + 1
                else l[i] = 2
            }
        }
        val r = IntArray(n) { 1 }
        for (i in n - 2 downTo 0) {
            val d = cmp.compare(nums[i + 1], nums[i])
            if (d != 0) {
                if (i < n - 2 && cmp.compare(nums[i + 2], nums[i + 1]) == -d) r[i] = r[i + 1] + 1
                else r[i] = 2
            }
        }

        var res = 0
        for (i in 0 until n)
            res = maxOf(res, l[i])

        for (i in 1 until n - 1) {
            val d = cmp.compare(nums[i + 1], nums[i - 1])
            if (d != 0) {
                val L = if (i > 1 && cmp.compare(nums[i - 1], nums[i - 2]) == -d) l[i - 1] else 1
                val R = if (i < n - 2 && cmp.compare(nums[i + 2], nums[i + 1]) == -d) r[i + 1] else 1
                res = maxOf(res, L + R)
            }
        }
        return res
    }
}
