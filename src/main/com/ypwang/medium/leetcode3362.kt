package com.ypwang.medium

import java.util.PriorityQueue

class Solution3362 {
    fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
        queries.sortWith(compareBy { it[0] })
        val ava = PriorityQueue<Int>(compareByDescending{ it })
        val cur = PriorityQueue<Int>()
        var queryIndex = 0

        for (i in nums.indices) {
            while (queryIndex < queries.size && queries[queryIndex][0] <= i) {
                ava.offer(queries[queryIndex][1])
                queryIndex++
            }

            while (cur.isNotEmpty() && cur.peek() < i)
                cur.poll()

            while (nums[i] > cur.size) {
                if (ava.isEmpty() || ava.peek() < i)
                    return -1
                cur.offer(ava.poll())
            }
        }

        return ava.size
    }
}

fun main() {
    println(Solution3362().maxRemoval(intArrayOf(4,5), arrayOf(
        intArrayOf(0,0),intArrayOf(0,1),intArrayOf(0,1),intArrayOf(0,1),intArrayOf(1,1),intArrayOf(1,1)
    )))
    println(Solution3362().maxRemoval(intArrayOf(1,1,1,1), arrayOf(
        intArrayOf(1,3),intArrayOf(0,2),intArrayOf(1,3),intArrayOf(1,2)
    )))
    println(Solution3362().maxRemoval(intArrayOf(2,0,2), arrayOf(
        intArrayOf(0,2), intArrayOf(0,2), intArrayOf(1,1)
    )))
}