package com.ypwang.medium

import java.util.Deque
import java.util.LinkedList

class Solution3578 {
    fun countPartitions(nums: IntArray, k: Int): Int {
        val n = nums.size
        val mod = 1000000007
        val dp = IntArray(n + 1)
        dp[0] = 1
        val acc = IntArray(n + 2)
        acc[1] = 1

        val minq: Deque<Int> = LinkedList()
        val maxq: Deque<Int> = LinkedList()
        var i = 0
        var j = 0
        while (j < n) {
            while (maxq.isNotEmpty() && nums[j] > nums[maxq.peekLast()])
                maxq.pollLast()
            maxq.addLast(j)

            while (minq.isNotEmpty() && nums[j] < nums[minq.peekLast()])
                minq.pollLast()
            minq.addLast(j)

            while (nums[maxq.peekFirst()] - nums[minq.peekFirst()] > k) {
                i++
                if (minq.peekFirst() < i)
                    minq.pollFirst()
                if (maxq.peekFirst() < i)
                    maxq.pollFirst()
            }

            dp[j + 1] = (acc[j + 1] - acc[i] + mod) % mod
            acc[j + 2] = (acc[j + 1] + dp[j + 1]) % mod
            j++
        }

        return dp[n]
    }
}
