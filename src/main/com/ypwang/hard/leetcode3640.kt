package com.ypwang.hard

class Solution3640 {
    val INCREASING = 0
    val DECREASING = 1

    fun maxSumTrionic(nums: IntArray): Long {
        val n = nums.size
        var ans = Long.MIN_VALUE

        val pre = LongArray(n)
        val indices = mutableListOf<Pair<Int, Int>>()

        for (i in nums.indices) {
            pre[i] = nums[i].toLong()
            if (i > 0)
                pre[i] += pre[i - 1]
        }

        fun updateAnswer(r: Int) {
            val sz = indices.size
            if (sz < 3)
                return
            if (indices[sz - 3].second != INCREASING)
                return
            var l = indices[sz - 3].first
            val p = indices[sz - 2].first
            val q = indices[sz - 1].first

            while (l + 1 < p && nums[l] < 0)
                l++

            val leftSum = if (l > 0) pre[l - 1] else 0L
            ans = maxOf(ans, pre[r] - leftSum)
            if (q + 1 < n)
                ans = maxOf(ans, pre[q + 1] - leftSum)
        }

        for (i in 1 until n) {
            if (nums[i] == nums[i - 1]) {
                updateAnswer(i - 1)
                indices.clear()
            } else {
                val state = if (nums[i - 1] < nums[i]) INCREASING else DECREASING
                if (indices.isEmpty() || indices.last().second != state) {
                    updateAnswer(i - 1)
                    indices.add(Pair(i - 1, state))
                }
            }
        }

        updateAnswer(n - 1)

        return ans
    }
}
