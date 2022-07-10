package com.ypwang.medium

import java.util.*

class SmallestInfiniteSet {
    val queue = PriorityQueue<Int>()
    var current = 1

    fun popSmallest(): Int {
        val result =
            if (queue.isNotEmpty() && queue.peek() < current)
                queue.poll()
            else
                current++

        while (queue.isNotEmpty() && queue.peek() == result)
            queue.poll()
        return result
    }

    fun addBack(num: Int) {
        queue.add(num)
    }
}