package com.ypwang.hard

class Solution3757 {
    fun countEffective(nums: IntArray): Int {
        val MOD = 1000000007
        val n = nums.size
        val T = nums.reduce { a, b -> a or b }

        if (T == 0)
            return 0
        val bits = IntArray(20)
        var M = 0
        for (b in 0..19)
            if (((T shr b) and 1) != 0) bits[M++] = b
        val S = 1 shl M
        val freq = IntArray(S)
        for (v in nums) {
            var m = 0
            for (j in 0 until M)
                if (((v shr bits[j]) and 1) != 0) m = m or (1 shl j)
            freq[m]++
        }

        val F = IntArray(S)
        for (i in 0 until S)
            F[i] = freq[i]
        for (i in 0 until M)
            for (mask in 0 until S)
                if ((mask and (1 shl i)) != 0)
                    F[mask] += F[mask xor (1 shl i)]

        val p2 = LongArray(n + 1)
        p2[0] = 1
        for (i in 1..n)
            p2[i] = (p2[i - 1] shl 1) % MOD
        var ans = 0L
        val all = S - 1
        for (bmask in 1 until S) {
            val comp = all xor bmask
            val cnt = F[comp]
            val add = p2[cnt]
            ans = if (Integer.bitCount(bmask) % 2 == 1)
                (ans + add) % MOD
            else (ans - add) % MOD
        }

        ans = (ans % MOD + MOD) % MOD
        return ans.toInt()
    }
}
