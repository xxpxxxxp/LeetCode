package com.ypwang.hard

class Solution1269 {
    private val mod = 1000000007
    fun numWays(steps: Int, arrLen: Int): Int =
        (0 until steps).fold(IntArray(arrLen+2).apply { this[1] = 1 }) { cp, _ ->
            IntArray(arrLen+2) {
                if (it in 1..arrLen) ((cp[it-1] + cp[it]) % mod + cp[it+1]) % mod else 0
            }
        }[1]
}

fun main() {
    println(Solution1269().numWays(3, 2))
    println(Solution1269().numWays(2, 4))
    println(Solution1269().numWays(4, 2))
}