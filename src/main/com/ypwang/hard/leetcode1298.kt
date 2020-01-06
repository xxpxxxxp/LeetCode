package com.ypwang.hard

import java.util.*

class Solution1298 {
    fun maxCandies(status: IntArray, candies: IntArray, keys: Array<IntArray>, containedBoxes: Array<IntArray>, initialBoxes: IntArray): Int {
        val accessableClosed = BooleanArray(status.size)
        initialBoxes.filter { status[it] == 0 }.forEach { accessableClosed[it] = true }

        val queue: Queue<Int> = LinkedList()
        queue.addAll(initialBoxes.filter { status[it] == 1 })

        var rst = 0
        while (queue.isNotEmpty()) {
            val box = queue.poll()
            rst += candies[box]

            keys[box].forEach {
                if (status[it] == 0 && accessableClosed[it])
                    queue.add(it)
                status[it] = 1
            }
            containedBoxes[box].forEach {
                if (status[it] == 1)
                    queue.add(it)
                else
                    accessableClosed[it] = true
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1298().maxCandies(intArrayOf(1,0,0,0,0,0), intArrayOf(1,1,1,1,1,1), arrayOf(
            intArrayOf(1,2,3,4,5), intArrayOf(), intArrayOf(), intArrayOf(), intArrayOf(), intArrayOf()
    ), arrayOf(
            intArrayOf(1,2,3,4,5), intArrayOf(), intArrayOf(), intArrayOf(), intArrayOf(), intArrayOf()
    ), intArrayOf(0)))
}