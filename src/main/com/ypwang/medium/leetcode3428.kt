package com.ypwang.medium

class Solution3428 {
    fun minMaxSums(nums: IntArray, k: Int): Int {
        nums.sort()
        val MOD = 1000000007L
        val n = nums.size
        val ncr = Array(n + 1) { LongArray(k + 1) { 0 } }

        ncr[0][0] = 1
        for (i in 1..n) {
            ncr[i][0] = 1
            for (j in 1..k)
                ncr[i][j] = (ncr[i - 1][j - 1] + ncr[i - 1][j]) % MOD
        }

        val ns = mutableListOf<Long>()
        for (i in n - 1 downTo 0) {
            var sum = 0L
            for (j in 0 until k) {
                if (i >= j)
                    sum = (sum + ncr[i][j]) % MOD
            }
            ns.add(sum)
        }

        var ans = 0L
        for (i in nums.indices)
            ans = (ans + (nums[i] + nums[n - i - 1].toLong()) * ns[i]) % MOD

        return (ans % MOD).toInt()
    }
}
