package com.ypwang.hard

import java.util.*

class Solution862 {
    fun shortestSubarray(A: IntArray, K: Int): Int {
        val deque: Deque<Pair<Int, Int>> = LinkedList()
        deque.addLast(-1 to 0)

        var dis = Int.MAX_VALUE
        var sum = 0
        for ((i, v) in A.withIndex()) {
            sum += v
            while (deque.isNotEmpty() && deque.last.second >= sum) {
                deque.removeLast()
            }
            while (deque.isNotEmpty() && sum - deque.first.second >= K) {
                dis = minOf(dis, i - deque.first.first)
                deque.removeFirst()
            }
            deque.addLast(i to sum)
        }

        return if (dis == Int.MAX_VALUE) -1 else dis
    }
}

fun main() {
    println(Solution862().shortestSubarray(intArrayOf(2,-1,2), 3))
}