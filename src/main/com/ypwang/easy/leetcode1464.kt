package com.ypwang.easy

import java.util.*

class Solution1464 {
    fun maxProduct(nums: IntArray): Int {
        val p = PriorityQueue<Int>()

        for (n in nums) {
            if (p.size > 2) p.poll()
            if (p.size < 2) p.add(n)
            else if (n > p.peek()) {
                p.poll()
                p.add(n)
            }
        }

        return (p.poll() - 1) * (p.poll() - 1)
    }
}