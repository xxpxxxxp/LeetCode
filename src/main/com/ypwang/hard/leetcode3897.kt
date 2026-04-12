package com.ypwang.hard

class Solution3897 {
    val MOD: Long = 1000000007L

    fun find(base: Long, exp: Long): Long {
        var base = base
        var exp = exp
        var res = 1L
        base %= MOD
        while (exp > 0) {
            if (exp % 2 == 1L) res = res * base % MOD
            base = base * base % MOD
            exp /= 2
        }
        return res
    }

    fun maxValue(nums1: IntArray, nums0: IntArray): Int {
        val n = nums1.size
        val a = mutableListOf<IntArray>()
        var last = 0

        for (i in 0 until n) {
            if (nums0[i] == 0)
                last += nums1[i]
            else
                a.add(intArrayOf(nums1[i], nums0[i]))
        }

        a.sortWith(compareByDescending<IntArray> { it[0] }.thenBy { it[1] })

        var ans = 0L
        var exp = 0L

        for ((one, zero) in a.reversed()) {
            exp += zero.toLong()
            val first = find(2, exp)
            val rn = find(2, one.toLong())
            val `val` = first * ((rn - 1 + MOD) % MOD) % MOD
            ans = (ans + `val`) % MOD
            exp += one.toLong()
        }

        val first = find(2, exp)
        val rn = find(2, last.toLong())
        val `val` = first * ((rn - 1 + MOD) % MOD) % MOD
        ans = (ans + `val`) % MOD

        return ans.toInt()
    }
}
