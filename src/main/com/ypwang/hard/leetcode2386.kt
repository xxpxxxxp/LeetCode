package com.ypwang.hard

import java.util.*

class Solution2386 {
    fun kSum(nums: IntArray, k: Int): Long {
        val sum = nums.filter { it > 0 }.map { it.toLong() }.sum()
        if (k == 1)
            return sum

        val n = nums.map { Math.abs(it) }.sorted().toIntArray()

        val pq = PriorityQueue(compareByDescending<Pair<Long, Int>>{ it.first })
        pq.offer(sum - n[0] to 0)
        for (j in 0 until k-2) {
            val (r, i) = pq.poll()
            if (i < n.lastIndex) {
                pq.offer(r + n[i] - n[i + 1] to i + 1)
                pq.offer(r - n[i + 1] to i + 1)
            }
        }
        return pq.poll().first
    }
}

fun main() {
    println(Solution2386().kSum(intArrayOf(492634335,899178915,230945927), 2))
    println(Solution2386().kSum(intArrayOf(2,4,-2), 5))
    println(Solution2386().kSum(intArrayOf(1,-2,3,4,-10,12), 16))
}