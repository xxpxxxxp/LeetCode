package com.ypwang.medium

class Solution3984 {
    val MOD = 1000000007

    fun divisibleGame(nums: IntArray): Int {
        val mx = nums.max()

        val cand = mutableSetOf<Int>()

        for (x in nums) {
            var d = 1
            while (d * d <= x) {
                if (x % d == 0) {
                    if (d > 1)
                        cand.add(d)
                    val e = x / d
                    if (e > 1)
                        cand.add(e)
                }
                d++
            }
        }

        cand.add(mx + 1)

        var diff = Long.MIN_VALUE
        var bk = Int.MAX_VALUE

        for (k in cand) {
            var curr = Long.MIN_VALUE
            var best = Long.MIN_VALUE

            for (x in nums) {
                val `val` = (if (x % k == 0) x else -x).toLong()

                if (curr < 0)
                    curr = `val`
                else
                    curr += `val`

                best = maxOf(best, curr)
            }

            if (best > diff || (best == diff && k < bk)) {
                diff = best
                bk = k
            }
        }

        var ans = ((diff % MOD) + MOD) % MOD
        ans = (ans * bk) % MOD

        return ans.toInt()
    }
}
