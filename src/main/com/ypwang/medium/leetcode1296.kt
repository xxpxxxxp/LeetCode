package com.ypwang.medium

import java.util.*

class Solution1296 {
    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
        val occu = nums.groupBy { it }.mapValues { it.value.size }.toList().sortedBy { it.first }

        var pre = -1 to 0
        val dec: Queue<Pair<Int, Int>> = LinkedList()

        // v: element num
        for ((i, v) in occu) {
            if (dec.isEmpty()) pre = -1 to 0
            if (dec.isNotEmpty() && pre.first+1 != i) return false
            if (v < pre.second) return false
            (v - pre.second).let { if (it != 0) dec.offer(i + k - 1 to it) }
            var cur = v
            if (dec.isNotEmpty() && dec.peek().first == i) cur -= dec.poll().second
            pre = i to cur
        }

        return pre.second == 0 && dec.isEmpty()
    }
}

fun main() {
    println(Solution1296().isPossibleDivide(intArrayOf(1,2,3,3,4,4,5,6), 4))
    println(Solution1296().isPossibleDivide(intArrayOf(3,2,1,2,3,4,3,4,5,9,10,11), 3))
    println(Solution1296().isPossibleDivide(intArrayOf(3,3,2,2,1,1), 3))
    println(Solution1296().isPossibleDivide(intArrayOf(1,2,3,4), 3))
}