package com.ypwang.hard

class Solution3139 {
    fun minCostToEqualizeArray(nums: IntArray, cost1: Int, cost2: Int): Int {
        val n = nums.size
        var mx = nums.max()!!
        val mod = 1000000007

        val ttl = mx * n.toLong() - nums.fold(0L) { a, b -> a + b }
        if (ttl == 0L)
            return 0

        if (cost1 * 2 <= cost2)
            return ((ttl * cost1) % mod).toInt()

        mx -= nums.min()!!
        if (mx * 2 <= ttl) {
            val halfTtl = ttl / 2
            var result = (halfTtl * cost2) % mod
            if (ttl % 2 == 1L)
                // Corner case with the last one spot left
                result += if (n % 2 == 1) minOf(cost1.toLong(), cost2.toLong() * (n + 1) / 2) else cost1.toLong()

            return (result % mod).toInt()
        }

        var result = (cost2 * (ttl - mx)) % mod
        var remainingMx = mx - (ttl - mx)
        if (remainingMx >= n - 1) {
            result += if (cost2 * (n - 1) >= cost1 * (n - 2)) {
                (remainingMx - remainingMx % (n - 1)) * cost1 % mod
            } else {
                remainingMx / (n - 2) * (n - 1) * cost2 % mod
            }
            remainingMx %= if (n - 1 > 0) n - 1 else 1
        }
        if (remainingMx > 0) {
            val lastRoundCost = (n + remainingMx shr 1) * cost2 % mod
            result += if (lastRoundCost > remainingMx * cost1) remainingMx * cost1 else lastRoundCost
        }
        return (result % mod).toInt()
    }
}
