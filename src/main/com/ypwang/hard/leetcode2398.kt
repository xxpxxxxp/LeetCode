package com.ypwang.hard

import java.util.*

class Solution2398 {
    fun maximumRobots(chargeTimes: IntArray, runningCosts: IntArray, budget: Long): Int {
        var sum: Long = 0
        var i = 0
        val d: Deque<Int> = LinkedList()
        for ((j, c) in runningCosts.withIndex()) {
            sum += c
            while (!d.isEmpty() && chargeTimes[d.peekLast()] <= chargeTimes[j])
                d.pollLast()
            d.addLast(j)

            if (chargeTimes[d.first] + (j - i + 1) * sum > budget) {
                if (d.first == i)
                    d.pollFirst()
                sum -= runningCosts[i++]
            }
        }
        return runningCosts.size - i
    }
}
