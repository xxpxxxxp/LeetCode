package com.ypwang.hard

class Solution2407 {
    private val N = 100001
    private val seg = IntArray(2 * N)

    private fun update(pos: Int, `val`: Int) {
        var pos = pos
        pos += N
        seg[pos] = `val`
        while (pos > 1) {
            pos = pos shr 1
            seg[pos] = maxOf(seg[2 * pos], seg[2 * pos + 1])
        }
    }

    private fun query(lo: Int, hi: Int): Int {
        var lo = lo
        var hi = hi
        lo += N
        hi += N
        var res = 0
        while (lo < hi) {
            if (lo and 1 == 1) {
                res = maxOf(res, seg[lo++])
            }
            if (hi and 1 == 1) {
                res = maxOf(res, seg[--hi])
            }
            lo = lo shr 1
            hi = hi shr 1
        }
        return res
    }

    fun lengthOfLIS(nums: IntArray, k: Int): Int {
        var ans = 0
        for (v in nums) {
            val res = query(maxOf(0, v - k), v) + 1 // best res for the current element
            ans = maxOf(res, ans)
            update(v, res) // and update it here
        }
        return ans
    }
}