package com.ypwang.hard

import java.util.*

class Solution1675 {
    fun minimumDeviation(nums: IntArray): Int {
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

        var max = Int.MIN_VALUE
        for (v in nums) {
            heap.add(
                if (v % 2 == 0) {
                    var t = v
                    while (t % 2 == 0)
                        t /= 2

                    max = maxOf(max, t)
                    t to v
                } else {
                    max = maxOf(max, v)
                    v to v * 2
                }
            )
        }


        var rst = Int.MAX_VALUE
        while (true) {
            val (c, m) = heap.poll()
            rst = minOf(rst, max - c)

            if (c == m)
                return rst

            max = maxOf(max, c * 2)
            heap.add(c * 2 to m)
        }
    }
}

fun main() {
    println(Solution1675().minimumDeviation(intArrayOf(3,5)))
    println(Solution1675().minimumDeviation(intArrayOf(1,2,3,4)))
    println(Solution1675().minimumDeviation(intArrayOf(4,1,5,20,3)))
    println(Solution1675().minimumDeviation(intArrayOf(2,10,8)))
}