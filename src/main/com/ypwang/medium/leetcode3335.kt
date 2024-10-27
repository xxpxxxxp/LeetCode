package com.ypwang.medium

class Solution3335 {
    val MOD = 1000000007
    val cache = mutableMapOf<Int, Int>()

    fun f(a: Int): Int {
        if (a < 26)
            return 1

        return cache.getOrPut(a){ (f(a - 26) + f(a - 26 + 1)) % MOD }
    }

    fun lengthAfterTransformations(s: String, t: Int): Int =
        s.map { it - 'a' + t }.fold(0L) { a, b -> (a + f(b)) % MOD }.toInt()
}
