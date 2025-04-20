package com.ypwang.medium

class Solution3524 {
    fun resultArray(nums: IntArray, k: Int): LongArray {
        val res = LongArray(k)
        var cnt = IntArray(k)
        for (a in nums) {
            val cnt2 = IntArray(k)
            for (i in 0..<k) {
                val v = ((i.toLong() * a) % k).toInt()
                cnt2[v] += cnt[i]
                res[v] += cnt[i].toLong()
            }
            cnt = cnt2
            cnt[a % k]++
            res[a % k]++
        }
        return res
    }
}
