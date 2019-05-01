package com.ypwang.medium

import java.util.*

class Solution915 {
    fun partitionDisjoint(A: IntArray): Int {
        val minStack = Stack<Pair<Int, Int>>()

        for ((i, v) in A.withIndex().reversed()) {
            if (minStack.isEmpty() || minStack.peek().second > v) {
                minStack.add(i to v)
            }
        }

        var max = Int.MIN_VALUE
        var minRight = minStack.peek().second
        for (i in 0 until A.size) {
            if (max < A[i]) max = A[i]
            if (i == minStack.peek().first) {
                minStack.pop()
                minRight = minStack.peek().second
            }

            if (max <= minRight) return i + 1
        }

        return 0
    }
}

fun main() {
    println(Solution915().partitionDisjoint(intArrayOf(1,1,1,0,6,12)))
}