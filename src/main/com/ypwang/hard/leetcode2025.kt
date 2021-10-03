package com.ypwang.hard

class Solution2025 {
    fun waysToPartition(nums: IntArray, k: Int): Int {
        val pre = LongArray(nums.size)
        val suf = LongArray(nums.size)

        pre[0] = nums[0].toLong()
        suf[nums.lastIndex] = nums.last().toLong()

        for (i in 1 until nums.size) {
            pre[i] = pre[i-1] + nums[i]
            suf[nums.lastIndex-i] = suf[nums.size-i] + nums[nums.lastIndex-i]
        }

        val left = mutableMapOf<Long, Int>()
        val right = mutableMapOf<Long, Int>()

        for(i in 0 until nums.lastIndex) {
            val diff = pre[i] - suf[i+1]
            right[diff] = right.getOrDefault(diff, 0) + 1
        }

        var ans = right.getOrDefault(0, 0)
        for (i in nums.indices) {
            val diff = (k - nums[i]).toLong()
            ans = maxOf(ans, left.getOrDefault(diff, 0) + right.getOrDefault(-diff, 0))

            if (i < nums.lastIndex) {
                val d = pre[i] - suf[i+1]
                left[d] = left.getOrDefault(d, 0) + 1
                right[d] = right[d]!!-1
                if (right[d] == 0)
                    right.remove(d)
            }
        }

        return ans
    }
}