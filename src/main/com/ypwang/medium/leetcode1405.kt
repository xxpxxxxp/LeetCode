package com.ypwang.medium

import java.lang.StringBuilder
import java.util.*

class Solution1405 {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val heap = PriorityQueue<Pair<Int, Char>>(compareByDescending{ it.first })
        if (a > 0) heap.add(a to 'a')
        if (b > 0) heap.add(b to 'b')
        if (c > 0) heap.add(c to 'c')

        val sb = StringBuilder()
        while (heap.isNotEmpty()) {
            val top = heap.poll()
            val printCount = minOf(2, top.first)
            repeat(printCount) { sb.append(top.second) }

            val count = top.first - printCount
            if (count == 0) continue
            if (heap.isEmpty()) break
            if (count >= heap.peek().first) {
                val next = heap.poll()
                sb.append(next.second)
                if (next.first > 1)
                    heap.add(next.first - 1 to next.second)
            }

            heap.add(count to top.second)
        }

        return sb.toString()
    }
}

fun main() {
    println(Solution1405().longestDiverseString(1,1,7))
    println(Solution1405().longestDiverseString(2,2,1))
    println(Solution1405().longestDiverseString(7,1,0))
}