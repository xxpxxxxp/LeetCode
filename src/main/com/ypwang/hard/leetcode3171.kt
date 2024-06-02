package com.ypwang.hard

class Solution3171 {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        if (nums.size == 1)
            return Math.abs(k - nums[0])

        val max = nums.max()!!
        if (k >= max)
            return k - max

        val fr = IntArray(31)

        var p1 = 0
        var p2 = 1

        var curr = nums[0]
        add(fr, nums[0])

        var ans = Int.MAX_VALUE
        while (p2 < nums.size) {
            ans = minOf(ans, Math.abs(curr - k))

            while (curr > k && p2 < nums.size) {
                add(fr, nums[p2])
                curr = cal(fr)
                ans = minOf(ans, Math.abs(curr - k))
                ++p2
            }

            while (curr < k && p1 < p2) {
                sub(fr, nums[p1])
                curr = cal(fr)
                ans = minOf(ans, Math.abs(curr - k))
                ++p1
            }

            if (curr == k)
                return 0
        }

        return ans
    }

    private fun cal(fr: IntArray): Int =
        fr.withIndex().fold(0) { rst, (i, v) ->
            if (v == 0)
                rst or (1 shl i)
            else
                rst
        }

    private fun add(fr: IntArray, value: Int) {
        for (i in 0 until 31)
            if (value and (1 shl i) == 0)
                fr[i]++
    }

    private fun sub(fr: IntArray, value: Int) {
        for (i in 0 until 31)
            if (value and (1 shl i) == 0)
                fr[i]--
    }
}
