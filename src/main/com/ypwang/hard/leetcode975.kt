package com.ypwang.hard

import java.util.*

class Solution975 {
    fun oddEvenJumps(A: IntArray): Int {
        val dp = Array(A.size){ BooleanArray(2) }
        dp[dp.lastIndex] = booleanArrayOf(true, true)

        var cnt = 1

        val oddNext = IntArray(A.size){-1}
        val evenNext = IntArray(A.size){-1}

        val stack = Stack<Int>()
        for (i in A.withIndex().sortedBy { it.value }.map { it.index }) {
            while (stack.isNotEmpty() && stack.peek() <= i) {
                oddNext[stack.pop()] = i
            }
            stack.push(i)
        }

        stack.clear()
        for (i in A.withIndex().sortedBy { -it.value }.map { it.index }) {
            while (stack.isNotEmpty() && stack.peek() <= i) {
                evenNext[stack.pop()] = i
            }
            stack.push(i)
        }

        for (i in A.lastIndex-1 downTo 0) {
            // odd jump
            if (oddNext[i] >= 0 && dp[oddNext[i]][1]) {
                dp[i][0] = true
                cnt++
            }

            // even jump
            if (evenNext[i] >= 0 && dp[evenNext[i]][0]) dp[i][1] = true
        }

        return cnt
    }
}

fun main() {
    println(Solution975().oddEvenJumps(intArrayOf(1,2,3,2,1,4,4,5)))
    println(Solution975().oddEvenJumps(intArrayOf(10,13,12,14,15)))
    println(Solution975().oddEvenJumps(intArrayOf(2,3,1,1,4)))
    println(Solution975().oddEvenJumps(intArrayOf(5,1,3,4,2)))
}