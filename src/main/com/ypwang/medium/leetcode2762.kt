package com.ypwang.medium

class Solution2762 {
    fun continuousSubarrays(nums: IntArray): Long {
        val maxQ = arrayListOf<Int>()
        val minQ = arrayListOf<Int>()
        var l = 0
        var res = 0L
        for ((r, v) in nums.withIndex()) {
            while (maxQ.isNotEmpty() && nums[maxQ.last()] < v) {
                maxQ.removeAt(maxQ.lastIndex)
            }
            maxQ.add(r)
            while (minQ.isNotEmpty() && nums[minQ.last()] > v) {
                minQ.removeAt(minQ.lastIndex)
            }
            minQ.add(r)
            while (maxQ.isNotEmpty() && minQ.isNotEmpty() && nums[maxQ.first()] - nums[minQ.first()] > 2) {
                if (maxQ.first() < minQ.first()) {
                    l = maxQ.first() + 1
                    maxQ.removeAt(0)
                } else {
                    l = minQ.first() + 1
                    minQ.removeAt(0)
                }
            }
            res += r - l + 1
        }
        return res
    }
}