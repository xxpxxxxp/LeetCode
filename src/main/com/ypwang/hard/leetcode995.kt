package com.ypwang.hard

import java.util.*

class Solution995 {
    fun minKBitFlips(A: IntArray, K: Int): Int {
        val queue: Queue<Int> = LinkedList()

        var count = 0
        for (i in 0 .. A.size - K) {
            while (queue.isNotEmpty() && queue.peek() <= i)
                queue.poll()

            if ((A[i] + queue.size) % 2 == 0) {
                // we need to flip current
                count++
                queue.offer(i + K)
            }
        }

        for (i in A.size - K + 1 until A.size) {
            while (queue.isNotEmpty() && queue.peek() <= i)
                queue.poll()

            if ((A[i] + queue.size) % 2 == 0)
                return -1
        }

        return count
    }
}

fun main() {
    println(Solution995().minKBitFlips(intArrayOf(0,0,0,1,0,1,1,0), 3))
}