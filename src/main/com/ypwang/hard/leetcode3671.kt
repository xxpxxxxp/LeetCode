package com.ypwang.hard

class Solution3671 {
    fun totalBeauty(nums: IntArray): Int {
        val MOD = 1_000_000_007
        val maxA = nums.max()

        // Precompute divisors
        val divisors = Array(maxA + 1) { mutableListOf<Int>() }
        for (d in 1..maxA) {
            var m = d
            while (m <= maxA) {
                divisors[m].add(d)
                m += d
            }
        }

        // Group nums by divisor
        val A = Array(maxA + 1) { mutableListOf<Int>() }
        for (x in nums)
            for (d in divisors[x])
                A[d].add(x)

        val numInc = IntArray(maxA + 1)

        fun countIncreasing(seq: List<Int>): Int {
            if (seq.isEmpty())
                return 0

            // Coordinate compression
            val vals = seq.toSortedSet().toList()
            val m = vals.size
            val bit = IntArray(m + 2)

            fun add(i0: Int, v: Int) {
                var i = i0
                while (i <= m) {
                    bit[i] = (bit[i] + v) % MOD
                    i += i and -i
                }
            }

            fun sum(i0: Int): Int {
                var i = i0
                var s = 0L
                while (i > 0) {
                    s += bit[i]
                    if (s >= MOD) s -= MOD
                    i -= i and -i
                }
                return s.toInt()
            }

            var total = 0L
            for (v in seq) {
                val r = vals.binarySearch(v) + 1 // index +1 for BIT
                val less = sum(r - 1)
                var addHere = less + 1
                if (addHere >= MOD)
                    addHere -= MOD
                add(r, addHere)
                total += addHere
                if (total >= MOD)
                    total -= MOD
            }
            return (total % MOD).toInt()
        }

        // Count subsequences for each divisor
        for (x in 1..maxA)
            if (A[x].isNotEmpty())
                numInc[x] = countIncreasing(A[x])

        // Inclusion-Exclusion (sieve style)
        val dp = IntArray(maxA + 1)
        for (x in maxA downTo 1) {
            var v = numInc[x].toLong()
            var y = x + x
            while (y <= maxA) {
                v -= dp[y]
                if (v < 0) v += MOD
                y += x
            }
            dp[x] = v.toInt()
        }

        // Final weighted sum
        var ans = 0L
        for (x in 1..maxA)
            if (dp[x] != 0)
                ans = (ans + 1L * x * dp[x]) % MOD

        return ans.toInt()
    }
}
