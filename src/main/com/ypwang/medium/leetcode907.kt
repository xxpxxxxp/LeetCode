package com.ypwang.medium

import java.util.*

class Solution907 {
    fun sumSubarrayMins(A: IntArray): Int {
        val mins = Stack<Pair<Int, Int>>()

        var sum = 0
        for (a in A) {
            var count = 1
            while (mins.isNotEmpty() && mins.peek().first > a)
                count += mins.pop().second

            mins.add(a to count)
            sum = (sum + mins.sumBy { it.first * it.second }) % 1000000007
        }

        return sum
    }
}

fun main() {
    println(Solution907().sumSubarrayMins(intArrayOf(3,1,2,4)))
}