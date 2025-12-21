package com.ypwang.hard

class Solution3785 {
    fun minSwaps(nums: IntArray, forbidden: IntArray): Int {
        val n = nums.size

        val cntNums = mutableMapOf<Int, Int>()
        val cntForb = mutableMapOf<Int, Int>()

        for (x in nums)
            cntNums[x] = cntNums.getOrDefault(x, 0)!! + 1
        for (x in forbidden)
            cntForb[x] = cntForb.getOrDefault(x, 0)!! + 1

        // Feasibility check
        for (`val` in cntNums.keys)
            if (cntNums[`val`]!! + cntForb.getOrDefault(`val`, 0) > n)
                return -1

        var bad = 0 // count of indices where nums[i] == forbidden[i]
        val cntBad  = mutableMapOf<Int, Int>()

        for (i in 0 until n)
            if (nums[i] == forbidden[i]) {
                bad++
                val v = nums[i]
                cntBad[v] = cntBad.getOrDefault(v, 0)!! + 1
            }

        return if (bad == 0) 0 else maxOf((bad + 1) / 2, cntBad.values.max())
    }
}
