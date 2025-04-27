package com.ypwang.hard

import kotlin.math.log10

class Solution3533 {
    fun concatenatedDivisibility(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val total = (1 shl n) - 1

        val multiplicationWithLen = IntArray(n)
        for (i in 0..<n) {
            val x = nums[i]
            val digits = (if (x == 0) 1 else log10(x.toDouble()).toInt() + 1)
            var m = 1L
            for (i in 0..<digits)
                m = (m * 10) % k
            multiplicationWithLen[i] = m.toInt()
        }

        val dp = mutableMapOf<Long, List<Int>?>()
        val list = solve(0, 0, n, k, total, nums, multiplicationWithLen, dp)
        if (list == null)
            return IntArray(0)

        return list.toIntArray()
    }

    private fun solve(
        mask: Int, rem: Int, n: Int, k: Int, total: Int, nums: IntArray, multiplicationWithLen: IntArray,
        dp: MutableMap<Long, List<Int>?>
    ): List<Int>? {
        if (mask == total)
            return if (rem == 0) emptyList() else null
        val key = mask * 100L + rem
        if (key in dp)
            return dp[key]

        var best: MutableList<Int>? = null
        for (i in 0..<n) {
            val bit = 1 shl i
            if ((mask and bit) != 0)
                continue

            val newRem = if (mask == 0) nums[i] % k else ((rem * multiplicationWithLen[i] + nums[i]) % k)
            val tail = solve(mask or bit, newRem, n, k, total, nums, multiplicationWithLen, dp)
            if (tail != null) {
                val cand = mutableListOf<Int>()
                cand.add(nums[i])
                cand.addAll(tail)
                if (best == null || compare(cand, best))
                    best = cand
            }
        }

        dp.put(key, best)
        return best
    }

    private fun compare(a: MutableList<Int>, b: MutableList<Int>): Boolean =
        a.zip(b).firstOrNull() { it.first != it.second }?.let { it.first < it.second } ?: true
}

fun main() {
    println(Solution3533().concatenatedDivisibility(intArrayOf(2,2,5), 36).toList())
    println(Solution3533().concatenatedDivisibility(intArrayOf(5,5), 5).toList())
    println(Solution3533().concatenatedDivisibility(intArrayOf(3,12,45), 5).toList())
}
