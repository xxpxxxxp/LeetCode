package com.ypwang.hard

import java.math.BigInteger

class Solution1923 {
    fun longestCommonSubpath(n: Int, paths: Array<IntArray>): Int {
        var l = 0
        var r = minOf(n, paths.map { it.size }.min()!!)

        fun helper(len: Int): Boolean {
            if (len == 0)
                return true

            return paths.map {
                var hash = 0L
                val p1 = 1299827L
                val p2 = 1000000007L
                for (i in 0 until len)
                    hash = (hash * p1 + it[i]) % p2

                val hashes = mutableSetOf(hash)

                val m = BigInteger.valueOf(p1)
                    .modPow(BigInteger.valueOf((len - 1).toLong()), BigInteger.valueOf(p2)).toLong()

                for (i in len until it.size) {
                    hash = (hash + p2 - m * it[i - len] % p2) % p2
                    hash = (hash * p1 + it[i]) % p2
                    hashes.add(hash)
                }

                hashes
            }.reduce { s1: Set<Long>, s2: Set<Long> -> s1.intersect(s2) }.isNotEmpty()
        }

        while (l < r) {
            val mid = (l + r + 1) / 2
            if (helper(mid))
                l = mid
            else
                r = mid - 1
        }

        return l
    }
}

fun main() {
    println(Solution1923().longestCommonSubpath(5, arrayOf(
        intArrayOf(0,1,0,1,0,1,0,1,0), intArrayOf(0,1,3,0,1,4,0,1,0)
    )))
    println(Solution1923().longestCommonSubpath(5, arrayOf(
        intArrayOf(0,1,2,3,4), intArrayOf(2,3,4), intArrayOf(4,0,1,2,3)
    )))
    println(Solution1923().longestCommonSubpath(3, arrayOf(
        intArrayOf(0), intArrayOf(1), intArrayOf(2)
    )))
    println(Solution1923().longestCommonSubpath(5, arrayOf(
        intArrayOf(0,1,2,3,4), intArrayOf(4,3,2,1,0)
    )))
}