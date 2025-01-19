package com.ypwang.hard

import java.util.Deque
import java.util.LinkedList

class Solution3420 {
    fun countNonDecreasingSubarrays(nums: IntArray, k: Int): Long {
        // Reverse the array
        nums.reverse()

        var res = 0L
        val q: Deque<Int> = LinkedList()
        var j = 0
        var i = 0
        var k = k.toLong()

        while (j < nums.size) {
            while (q.isNotEmpty() && nums[q.last()] < nums[j]) {
                val r = q.removeLast()
                val l = if (q.isEmpty()) i - 1 else q.last()
                k -= 1L * (r - l) * (nums[j] - nums[r])
            }
            q.addLast(j)
            while (k < 0) {
                k += nums[q.first()] - nums[i]
                if (q.first() == i)
                    q.removeFirst()
                i++
            }
            res += j - i + 1
            j++
        }
        return res
    }
}
