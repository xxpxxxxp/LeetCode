package com.ypwang.medium


class Solution3623 {
    fun countTrapezoids(points: Array<IntArray>): Int {
        val MOD = 1000000007L
        val mp = mutableMapOf<Int, MutableList<IntArray>>()

        for (point in points)
            mp.getOrPut(point[1], { mutableListOf() }).add(point)

        val pairCounts = mutableListOf<Long>()

        for (v in mp.values) {
            val count = v.size.toLong()
            if (count >= 2) {
                val pairs = (count * (count - 1)) / 2
                pairCounts.add(pairs)
            }
        }

        var totalSum = 0L
        var squareSum = 0L

        for (`val` in pairCounts) {
            val modVal = `val` % MOD
            totalSum = (totalSum + modVal) % MOD
            squareSum = (squareSum + (modVal * modVal) % MOD) % MOD
        }

        // (totalSum^2 - squareSum) / 2 mod MOD
        val totalSquare = (totalSum * totalSum) % MOD
        val diff = (totalSquare - squareSum + MOD) % MOD
        val inverseTwo = powMod(2, MOD - 2, MOD) // Modular inverse of 2

        return ((diff * inverseTwo) % MOD).toInt()
    }

    private fun powMod(base: Long, exp: Long, mod: Long): Long {
        var base = base
        var exp = exp
        var result: Long = 1
        base = base % mod
        while (exp > 0) {
            if ((exp and 1L) == 1L) result = (result * base) % mod
            base = (base * base) % mod
            exp = exp shr 1
        }
        return result
    }
}
