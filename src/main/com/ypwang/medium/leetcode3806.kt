package com.ypwang.medium

class Solution3806 {
    private fun getOps(x: Int, t: Int): Int {
        if ((x and t) == t)
            return 0

        var cur = 0
        for (i in 30 downTo 0) {
            val tBit = t and (1 shl i)
            val xBit = x and (1 shl i)
            if (tBit != 0 && xBit == 0) {
                cur = cur or (1 shl i)
                cur = cur or (t and ((1 shl i) - 1))
                return cur - x
            }
            if (xBit != 0)
                cur = cur or (1 shl i)
        }
        return cur - x
    }

    fun maximumAND(nums: IntArray, k: Int, m: Int): Int {
        var cur = 0
        for (i in 30 downTo 0) {
            val t = cur or (1 shl i)
            val cost = IntArray(nums.size) { getOps(nums[it], t) }
            cost.sort()
            var need = 0L
            for (j in 0 until m) {
                need += cost[j]
                if (need > k)
                    break
            }

            if (need <= k)
                cur = t
        }

        return cur
    }
}
