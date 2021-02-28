package com.ypwang.hard

import java.util.*

class Solution1776 {
    fun getCollisionTimes(A: Array<IntArray>): DoubleArray {
        val stack: Deque<Int> = LinkedList()
        val res = DoubleArray(A.size)
        for (i in A.lastIndex downTo 0) {
            res[i] = -1.0
            val (p, s) = A[i]
            while (stack.size > 0) {
                val j = stack.peekLast()
                val (p2, s2) = A[j]
                if (s <= s2 || 1.0 * (p2 - p) / (s - s2) >= res[j] && res[j] > 0)
                    stack.pollLast()
                else
                    break
            }
            if (stack.size > 0) {
                val (p2, s2) = A[stack.peekLast()]
                res[i] = 1.0 * (p2 - p) / (s - s2)
            }
            stack.add(i)
        }
        return res
    }
}