package com.ypwang.easy

class Solution2670 {
    fun distinctDifferenceArray(nums: IntArray): IntArray {
        val post = nums.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val pre = mutableMapOf<Int, Int>()
        val rst = IntArray(nums.size)
        for ((i, n) in nums.withIndex()) {
            pre[n] = pre.getOrDefault(n, 0) + 1
            val c = post[n]!!
            if (c == 1)
                post.remove(n)
            else
                post[n] = c-1

            rst[i] = pre.size - post.size
        }
        return rst
    }
}
