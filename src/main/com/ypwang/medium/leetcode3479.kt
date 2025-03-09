package com.ypwang.medium

import java.util.Deque
import java.util.LinkedList

class Solution3479 {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        val queue: Deque<Int> = LinkedList()
        for (b in baskets)
            queue.addLast(b)

        val maxB = baskets.max()

        for (fruit in fruits) {
            if (fruit > maxB)
                continue

            val res = mutableListOf<Int>()
            while (queue.isNotEmpty() && queue.first() < fruit)
                res.add(queue.removeFirst())

            if (queue.isNotEmpty() && queue.first() >= fruit)
                queue.removeFirst()

            while (res.isNotEmpty())
                queue.addFirst(res.removeAt(res.size - 1))
        }

        return queue.size
    }
}
