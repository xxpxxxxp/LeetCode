package com.ypwang.medium

class Solution3835 {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        val maxq = ArrayDeque<Int>()
        val minq = ArrayDeque<Int>()

        var res = 0L
        var l = 0
        for (r in 0 until nums.size) {
            while (maxq.isNotEmpty() && nums[maxq.last()] <= nums[r])
                maxq.removeLast()
            maxq.addLast(r)

            while (minq.isNotEmpty() && nums[minq.last()] >= nums[r])
                minq.removeLast()
            minq.addLast(r)

            while (l <= r && (r - l + 1).toLong() * (nums[maxq.first()].toLong() - nums[minq.first()].toLong()) > k) {
                if (maxq.isNotEmpty() && maxq.first() <= l)
                    maxq.removeFirst()
                if (minq.isNotEmpty() && minq.first() <= l)
                    minq.removeFirst()
                l++
            }

            res += (r - l + 1).toLong()
        }

        return res
    }
}
