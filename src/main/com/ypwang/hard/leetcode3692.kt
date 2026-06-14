package com.ypwang.hard

import java.util.PriorityQueue

class Solution {
    fun maxSum(nums: IntArray, k: Int): Long {
        val n = nums.size
        // In C++, INT_MIN is an integer (-2147483648).
        // We initialize to Int.MIN_VALUE.toLong() to match the exact C++ behavior.
        var ans = Int.MIN_VALUE.toLong()

        if (k == 0 || n == 1) {
            var sm = 0L
            for (num in nums) {
                sm += num.toLong()
                ans = maxOf(ans, sm)
                if (sm < 0) sm = 0L
            }
            return ans
        }

        var cnt = 0
        var curSum = 0L
        val pref = LongArray(n + 1) { 0L }

        for (i in 0 until n) {
            if (nums[i] >= 0) {
                curSum += nums[i].toLong()
            } else {
                cnt++
            }
            pref[i + 1] = pref[i] + nums[i].toLong()
            ans = maxOf(ans, nums[i].toLong())
        }

        if (cnt <= k)
            return curSum

        val dp = Array(n) { LongArray(n) { 0L } }

        for (i in 0 until n) {
            // Equivalent to C++ priority_queue<int> (which is a max-heap)
            val pq = PriorityQueue<Int>(compareByDescending { it })
            var sm = 0L

            for (j in i until n) {
                if (nums[j] >= 0) {
                    dp[i][j] = sm
                    continue
                }

                if (pq.size < k) {
                    pq.offer(nums[j])
                    sm += nums[j].toLong()
                } else {
                    if (pq.peek() > nums[j]) {
                        sm -= pq.poll().toLong()
                        sm += nums[j].toLong()
                        pq.offer(nums[j])
                    }
                }
            }
        }

        for (i in 0 until n) {
            // Equivalent to C++ priority_queue<int, vector<int>, greater<int>> (min-heap)
            val pqmax = PriorityQueue<Int>()
            var sm = 0L

            for (j in 0 until i) {
                if (nums[j] < 0)
                    continue

                if (pqmax.size < k) {
                    pqmax.offer(nums[j])
                    sm += nums[j].toLong()
                } else {
                    if (pqmax.peek() < nums[j]) {
                        sm -= pqmax.poll().toLong()
                        sm += nums[j].toLong()
                        pqmax.offer(nums[j])
                    }
                }
            }

            for (j in n - 1 downTo i + 1) {
                var cur = pref[j + 1] - pref[i]
                cur -= dp[i][j]
                cur += sm

                ans = maxOf(ans, cur)

                if (nums[j] < 0)
                    continue

                if (pqmax.size < k) {
                    pqmax.offer(nums[j])
                    sm += nums[j].toLong()
                } else {
                    if (pqmax.peek() < nums[j]) {
                        sm -= pqmax.poll().toLong()
                        sm += nums[j].toLong()
                        pqmax.offer(nums[j])
                    }
                }

                if (pqmax.isNotEmpty())
                    ans = maxOf(ans, sm)
            }
        }

        return ans
    }
}
