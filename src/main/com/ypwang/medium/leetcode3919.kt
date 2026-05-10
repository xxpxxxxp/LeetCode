package com.ypwang.medium

class Solution3919 {
    fun minCost(nums: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums.size
        val v1 = LongArray(n)
        val v2 = LongArray(n)

        for (i in 0 until n - 1) {
            v1[i + 1] =
                if (i == 0 || nums[i] - nums[i - 1] > nums[i + 1] - nums[i])
                    v1[i] + 1
                else
                    v1[i] + nums[i + 1] - nums[i]
        }

        for (i in 1 until n) {
            v2[i] =
                if (i == n - 1 || nums[i] - nums[i - 1] <= nums[i + 1] - nums[i])
                    v2[i - 1] + 1
                else
                    v2[i - 1] + nums[i] - nums[i - 1]
        }

        return queries.map { (l, r) ->
            if (l < r)
                (v1[r] - v1[l]).toInt()
            else
                (v2[l] - v2[r]).toInt()
        }.toIntArray()
    }
}
