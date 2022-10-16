package com.ypwang.hard

class Solution2440 {
    fun componentValue(nums: IntArray, edges: Array<IntArray>): Int {
        val graph = Array(nums.size){ mutableListOf<Int>() }
        for ((a, b) in edges) {
            graph[a].add(b)
            graph[b].add(a)
        }

        fun helper(i: Int, prev: Int, target: Int): Int {
            if (graph[i].size == 1 && graph[i][0] == prev) {
                if (nums[i] > target)
                    return -1
                return if (nums[i] == target) 0 else nums[i]
            }
            var sum = nums[i]
            for (k in graph[i]) {
                if (k == prev)
                    continue
                val ans = helper(k, i, target)
                if (ans == -1)
                    return -1
                sum += ans
            }
            if (sum > target)
                return -1
            return if (sum == target) 0 else sum
        }

        val sum = nums.sum()
        for (k in nums.size downTo 1) {
            if (sum % k != 0)
                continue
            val ans = helper(0, -1, sum / k)
            if (ans == 0)
                return k - 1
        }
        return 0
    }
}