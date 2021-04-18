package com.ypwang.medium

import java.util.*

class Solution1834 {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        if (tasks.isEmpty())
            return intArrayOf()

        val rst = mutableListOf<Int>()
        // idx, time
        val heap = PriorityQueue(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

        val st = tasks.withIndex().sortedBy { it.value[0] }.toTypedArray()
        var start = 0
        var i = 0
        while (i < st.size) {
            if (heap.isEmpty() && start < st[i].value[0])
                start = st[i].value[0]

            while (i < st.size && st[i].value[0] <= start) {
                heap.add(st[i].index to st[i].value[1])
                i++
            }

            val (idx, time) = heap.poll()
            rst.add(idx)
            start += time
        }

        rst.addAll(heap.toList().sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first }).map { it.first })

        return rst.toIntArray()
    }
}

fun main() {
    println(Solution1834().getOrder(
        arrayOf(intArrayOf(35,36),intArrayOf(11,7),intArrayOf(15,47),intArrayOf(34,2),intArrayOf(47,19),intArrayOf(16,14),intArrayOf(19,8),intArrayOf(7,34),intArrayOf(38,15),intArrayOf(16,18),intArrayOf(27,22),intArrayOf(7,15),intArrayOf(43,2),intArrayOf(10,5),intArrayOf(5,4),intArrayOf(3,11))
    ).toList())
    println(Solution1834().getOrder(
        arrayOf(intArrayOf(19,13),intArrayOf(16,9),intArrayOf(21,10),intArrayOf(32,25),intArrayOf(37,4),intArrayOf(49,24),intArrayOf(2,15),intArrayOf(38,41),intArrayOf(37,34),intArrayOf(33,6),intArrayOf(45,4),intArrayOf(18,18),intArrayOf(46,39),intArrayOf(12,24))
    ).toList())
    println(Solution1834().getOrder(
        arrayOf(intArrayOf(1,2),intArrayOf(2,4),intArrayOf(3,2),intArrayOf(4,1))
    ).toList())
    println(Solution1834().getOrder(
        arrayOf(intArrayOf(7,10),intArrayOf(7,12),intArrayOf(7,5),intArrayOf(7,4),intArrayOf(7,2))
    ).toList())
}