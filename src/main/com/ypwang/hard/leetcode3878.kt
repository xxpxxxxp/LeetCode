package com.ypwang.hard

class Solution3878 {
    fun countGoodSubarrays(nums: IntArray): Long {
        val n = nums.size

        val prevOne = IntArray(31) { -1 }
        val nextOne = IntArray(31) { n }

        val L = IntArray(n)
        val R = IntArray(n) { n - 1 }

        for (i in 0 until n) {
            for (bit in 0..30) {
                if ((nums[i] and (1 shl bit)) == 0)
                    L[i] = maxOf(L[i], prevOne[bit] + 1)
                else
                    prevOne[bit] = i
            }
        }

        for (i in n - 1 downTo 0) {
            for (bit in 0..30) {
                if ((nums[i] and (1 shl bit)) == 0)
                    R[i] = minOf(R[i], nextOne[bit] - 1)
                else
                    nextOne[bit] = i
            }
        }

        var ans = 0L
        val lastIdx = mutableMapOf<Int, Int>()

        for (i in 0 until n) {
            var l = L[i]
            val r = R[i]

            if (nums[i] in lastIdx)
                l = maxOf(l, lastIdx[nums[i]]!! + 1)

            lastIdx[nums[i]] = i
            ans += 1L * (i - l + 1) * (r - i + 1)
        }

        return ans
    }
}
