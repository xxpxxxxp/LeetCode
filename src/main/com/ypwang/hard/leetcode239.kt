package com.ypwang.hard

class Solution239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty() || k == 0) return IntArray(0)
        val rst = IntArray(nums.size - k + 1)
        val queue = mutableListOf<Int>()
        for (i in 0 until nums.size) {
            while (queue.isNotEmpty() && queue.first() < i - k + 1)
                queue.removeAt(0)

            // remove smaller numbers in k range as they are useless
            while (queue.isNotEmpty() && nums[queue.last()] < nums[i])
                queue.removeAt(queue.lastIndex)

            queue.add(i)
            if (i in k-1 until nums.size) {
                rst[i-k+1] = nums[queue.first()]
            }
        }
        return rst
    }
}

fun main() {
    println(Solution239().maxSlidingWindow(intArrayOf(1,3,1,2,0,5), 3).toList())
}