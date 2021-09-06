package com.ypwang.hard

import java.math.BigInteger

class Solution1994 {
    fun numberOfGoodSubsets(nums: IntArray): Int {
        val mod = 1000000007
        val bad = setOf(1, 4, 8, 9, 12, 16, 18, 20, 24, 25, 27, 28)
        val primes = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
        val cnt = nums.filter { it !in bad }.groupBy { it }.mapValues { it.value.size.toLong() }.toList().toTypedArray()
        val masks = cnt.map { primes.withIndex().map { (i, v) -> if (it.first % v == 0) 1 shl i else 0 }.sum() }.toTypedArray()

        val dp = Array(cnt.size) { IntArray(1024) { -1 } }

        fun helper(idx: Int, mask: Int): Int {
            if (idx == cnt.size)
                return if (mask != 0) 1 else 0

            if (dp[idx][mask] == -1) {
                // not take idx
                var rst = helper(idx+1, mask).toLong()
                if (mask and masks[idx] == 0) {
                    // take idx
                    rst = (rst + helper(idx+1, mask or masks[idx]) * cnt[idx].second) % mod
                }

                dp[idx][mask] = rst.toInt()
            }

            return dp[idx][mask]
        }

        return ((helper(0, 0) *
                BigInteger.valueOf(2L).modPow(BigInteger.valueOf(nums.count { it == 1 }.toLong()), BigInteger.valueOf(mod.toLong())).toLong())
                % mod).toInt()
    }
}

fun main() {
    println(Solution1994().numberOfGoodSubsets(intArrayOf(5,10,1,26,24,21,24,23,11,12,27,4,17,16,2,6,1,1,6,8,13,30,24,20,2,19)))
    println(Solution1994().numberOfGoodSubsets(intArrayOf(1,2,3,4)))
    println(Solution1994().numberOfGoodSubsets(intArrayOf(4,2,3,15)))
}