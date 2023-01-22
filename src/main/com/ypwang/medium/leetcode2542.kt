package com.ypwang.medium

import java.util.*


class Solution2542 {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val q = nums1.zip(nums2).sortedByDescending { it.second }
        val pq = PriorityQueue<Int>()
        var res = 0L
        var sum = 0L
        for ((a, b) in q) {
            pq.add(a)
            sum += a
            if (pq.size > k)
                sum -= pq.poll()
            if (pq.size == k)
                res = maxOf(res, sum * b)
        }
        return res
    }
}