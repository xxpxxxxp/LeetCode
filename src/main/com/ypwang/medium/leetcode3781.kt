package com.ypwang.medium

import java.util.PriorityQueue

class Solution3781 {
    fun maximumScore(nums: IntArray, s: String): Long {
        val heap = PriorityQueue<Int>(compareByDescending { it })
        var rst = 0L
        for (i in nums.indices) {
            heap.add(nums[i])
            if (s[i] == '1')
                rst += heap.poll()
        }

        return rst
    }
}
