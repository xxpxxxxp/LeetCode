package com.ypwang.medium

import java.util.*

class Solution1642 {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        var b = bricks
        var l = ladders
        val heap = PriorityQueue<Int>()
        for (i in 1 until heights.size) {
            if (heights[i] > heights[i-1]) {
                val diff = heights[i] - heights[i-1]

                if (b >= diff) {
                    b -= diff
                    heap.offer(diff)
                } else {
                    if (l == 0)
                        return i-1

                    if (heap.isNotEmpty() && heap.peek() < diff) {
                        b += diff - heap.poll()
                        heap.offer(diff)
                    }
                    l--
                }
            }
        }

        return heights.lastIndex
    }
}

fun main() {
    println(Solution1642().furthestBuilding(intArrayOf(14,3,19,3), 17, 0))
    println(Solution1642().furthestBuilding(intArrayOf(4,12,2,7,3,18,20,3,19), 10, 2))
}