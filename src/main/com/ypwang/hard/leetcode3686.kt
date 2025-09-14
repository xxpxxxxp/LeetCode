package com.ypwang.hard

class Solution3686 {
    private val MOD = 1000000007L

    fun countStableSubsequences(nums: IntArray): Int {
        var e1 = 0L
        var e2 = 0L
        var o1 = 0L
        var o2 = 0L

        for (x in nums) {
            if ((x and 1) == 0) { // even
                val ne1 = (e1 + (o1 + o2 + 1)) % MOD
                val ne2 = (e2 + e1) % MOD
                e1 = ne1
                e2 = ne2
            } else { // odd
                val no1 = (o1 + (e1 + e2 + 1)) % MOD
                val no2 = (o2 + o1) % MOD
                o1 = no1
                o2 = no2
            }
        }

        val ans = (e1 + e2 + o1 + o2) % MOD
        return ans.toInt()
    }
}
