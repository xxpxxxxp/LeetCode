package com.ypwang.medium

import java.util.LinkedList
import java.util.Queue

class Solution2772 {
    fun checkArray(nums: IntArray, k: Int): Boolean {
        val mins: Queue<Pair<Int, Int>> = LinkedList()

        var m = 0
        for ((i, c) in nums.withIndex()) {
            while (mins.isNotEmpty() && mins.peek().first <= i) {
                m -= mins.poll().second
            }
            if (m > c)
                return false

            if (m != c) {
                if (i + k > nums.size)
                    return false

                mins.add(i + k to c - m)
                m = c
            }
        }

        return true
    }
}

fun main() {
    println(Solution2772().checkArray(intArrayOf(2,2,3,1,1,0), 3))
    println(Solution2772().checkArray(intArrayOf(1,3,1,1), 2))
}