package com.ypwang.medium

class Solution974 {
    fun subarraysDivByK(A: IntArray, K: Int): Int {
        val cache = mutableMapOf(0 to 1)

        var sum = 0
        var count = 0

        for (a in A) {
            sum += a
            var mod = sum % K

            if (mod < 0)
                mod += K

            cache[mod] = cache.getOrDefault(mod, 0) + 1
            count += cache[mod]!! - 1
        }

        return count
    }
}

fun main() {
    println(Solution974().subarraysDivByK(intArrayOf(2,-2,2,-4), 6))
}