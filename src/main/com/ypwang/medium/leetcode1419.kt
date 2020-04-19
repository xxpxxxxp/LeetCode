package com.ypwang.medium

import java.util.*

class Solution1419 {
    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        if (croakOfFrogs.length % 5 != 0) return -1
        val each = croakOfFrogs.length / 5

        val idxs = croakOfFrogs.withIndex().groupBy { it.value }.mapValues { it.value.map { iv -> iv.index } }
        if (idxs.any { it.value.size != each }) return -1

        val iterators = "croak".map { idxs[it]!!.iterator() }
        val queue: Queue<Int> = LinkedList()
        var max = 0
        for (i in 0 until each) {
            val round = iterators.map { it.next() }
            if ((0 until round.lastIndex).any { round[it] > round[it+1] }) return -1

            while (queue.isNotEmpty() && queue.peek() < round.first())
                queue.poll()

            queue.add(round.last())
            max = maxOf(max, queue.size)
        }

        return max
    }
}

fun main() {
    println(Solution1419().minNumberOfFrogs("croakcroak"))
    println(Solution1419().minNumberOfFrogs("crcoakroak"))
    println(Solution1419().minNumberOfFrogs("croakcrook"))
    println(Solution1419().minNumberOfFrogs("croakcroa"))
}