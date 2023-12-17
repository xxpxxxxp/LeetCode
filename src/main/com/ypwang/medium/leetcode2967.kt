package com.ypwang.medium

class Solution2967 {
    private fun mirroring(s: String): String {
        val half = s.substring(0, s.length / 2)
        return half + (if (s.length % 2 == 1) s[s.length / 2] else "") + half.reversed()
    }

    private fun nearestPalindromics(n: String): List<String> {
        val a = mirroring(n)

        var s = StringBuilder(n)
        var i = (s.length - 1) / 2
        while (i >= 0 && s[i] == '0') {
            s.replace(i, i + 1, "9")
            i--
        }
        if (i == 0 && s[i] == '1') {
            s.delete(0, 1)
            val mid = (s.length - 1) / 2
            s.replace(mid, mid + 1, "9")
        } else
            s.replace(i, i + 1, "" + (s[i].toInt() - 1).toChar())
        val b = mirroring(s.toString())

        s = StringBuilder(n)
        i = (s.length - 1) / 2
        while (i >= 0 && s[i] == '9') {
            s.replace(i, i + 1, "0")
            i--
        }
        if (i < 0) {
            s.insert(0, "1")
        } else
            s.replace(i, i + 1, "" + (s[i].toInt() + 1).toChar())
        val c = mirroring(s.toString())

        return listOf(a, b, c)
    }

    fun minimumCost(nums: IntArray): Long {
        nums.sort()
        val n = nums.size
        val median = if (n % 2 == 0) (nums[(n + 1) / 2] + nums[n / 2])/ 2 else nums[n / 2]

        var rst = Long.MAX_VALUE
        for (r in nearestPalindromics(median.toString()).map { it.toInt() }) {
            rst = minOf(rst, nums.map { Math.abs(r - it) }.fold(0L) { a, b -> a + b })
        }
        return rst
    }
}