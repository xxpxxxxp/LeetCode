package com.ypwang.hard

import java.util.*

class Solution1425 {
    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        var res = nums[0]
        val q: Deque<Int> = ArrayDeque()
        for (i in nums.indices) {
            nums[i] += if (!q.isEmpty()) q.peek() else 0
            res = maxOf(res, nums[i])
            while (!q.isEmpty() && nums[i] > q.peekLast()) q.pollLast()
            if (nums[i] > 0) q.offer(nums[i])
            if (i >= k && !q.isEmpty() && q.peek() == nums[i - k]) q.poll()
        }
        return res
    }
}