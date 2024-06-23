package com.ypwang.medium

import java.util.*

class Solution3191 {
    fun minOperations(nums: IntArray): Int {
        val q: Queue<Int> = LinkedList()
        var rst = 0
        for ((i, v) in nums.withIndex()) {
            while (q.isNotEmpty() && q.peek() + 2 < i)
                q.poll()

            if (!((v == 1) xor (q.size % 2 == 1))) {
                rst++
                q.add(i)
            }
        }

        while (q.isNotEmpty() && q.peek() + 2 < nums.size)
            q.poll()

        return if (q.isEmpty()) rst else -1
    }
}

fun main() {
    println(Solution3191().minOperations(intArrayOf(0,1,1,1,0,0)))
}