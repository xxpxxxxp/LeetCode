package com.ypwang.hard

class Solution3444 {
    fun minimumIncrements(nums: IntArray, target: IntArray): Int {
        val m = target.size
        val fullMask = (1 shl m) - 1
        val lcmArr = LongArray(1 shl m)

        for (mask in 1 until (1 shl m)) {
            var L = 1L
            for (j in 0 until m) {
                if (mask and (1 shl j) != 0) {
                    L = lcm(L, target[j].toLong())
                }
            }
            lcmArr[mask] = L
        }

        val INF = Long.MAX_VALUE / 2
        var dp = LongArray(1 shl m) { INF }
        dp[0] = 0

        for (x in nums) {
            val newdp = dp.copyOf()
            for (mask in 1 until (1 shl m)) {
                val L = lcmArr[mask]
                val r = x % L
                val cost = if (r == 0L) 0 else L - r
                for (old in 0 until (1 shl m)) {
                    val newMask = old or mask
                    newdp[newMask] = minOf(newdp[newMask], dp[old] + cost)
                }
            }
            dp = newdp
        }
        return dp[fullMask].toInt()
    }

    private fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }

    private fun lcm(a: Long, b: Long): Long {
        return a / gcd(a, b) * b
    }
}
