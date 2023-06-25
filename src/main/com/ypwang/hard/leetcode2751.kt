package com.ypwang.hard

import java.util.*

class Solution2751 {
    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val stack = Stack<Int>()

        for ((i, p) in positions.withIndex().sortedBy { it.value }) {
            if (directions[i] == 'R')
                stack.push(i)
            else {
                while (stack.isNotEmpty()) {
                    val j = stack.peek()
                    if (healths[i] == healths[j]) {
                        // remove both
                        healths[i] = 0
                        healths[j] = 0
                        stack.pop()
                        break
                    } else if (healths[i] > healths[j]) {
                        healths[i]--
                        healths[j] = 0
                        stack.pop()
                    } else {
                        healths[i] = 0
                        healths[j]--
                        break
                    }
                }
            }
        }
        return healths.filter { it > 0 }
    }
}