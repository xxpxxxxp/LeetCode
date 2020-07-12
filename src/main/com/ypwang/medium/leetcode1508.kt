package com.ypwang.medium

import java.util.*

class Solution1508 {
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        heap.addAll(nums.withIndex().map { it.index to it.value })

        var rst = 0
        for (t in 1..right) {
            val (i, v) = heap.poll()
            if (t >= left) rst = (rst + v) % 1000000007
            if (i < nums.lastIndex)
                heap.add(i+1 to v + nums[i+1])
        }

        return rst
    }
}