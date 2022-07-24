package com.ypwang.hard

class Solution2354 {
    fun countExcellentPairs(nums: IntArray, k: Int): Long {
        var res = 0L
        val cnt = LongArray(30)
        for (n in nums.toSet()) {
            cnt[Integer.bitCount(n)]++
        }
        for (i in 1..29)
            for (j in maxOf(i, k - i)..29)
                res += cnt[i] * cnt[j] * if (i == j) 1 else 2
        return res
    }
}