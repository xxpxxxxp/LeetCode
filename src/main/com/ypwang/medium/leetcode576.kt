package com.ypwang.medium

class Solution576 {
    private val mod = 1000000007

    fun findPaths(m: Int, n: Int, N: Int, i: Int, j: Int): Int {
        if (N == 0) return 0

        val cache = mutableMapOf<Int, Int>()
        fun helper(x: Int, y: Int, k: Int): Int {
            if (k == 1) {
                var count = 0
                if (x == 0) count++
                if (x == m-1) count++
                if (y == 0) count++
                if (y == n-1) count++
                return count
            }

            val idx = (x shl 16) + (y shl 8) + k
            if (idx !in cache) {
                var count = 0
                count = (count + if (x == 0) 1 else helper(x-1, y, k-1)) % mod
                count = (count + if (x == m-1) 1 else helper(x+1, y, k-1)) % mod
                count = (count + if (y == 0) 1 else helper(x, y-1, k-1)) % mod
                count = (count + if (y == n-1) 1 else helper(x, y+1, k-1)) % mod
                cache[idx] = count
            }
            return cache[idx]!!
        }

        return helper(i, j, N)
    }
}

fun main() {
    println(Solution576().findPaths(2, 3, 8, 1, 0))
}