package com.ypwang.medium

import java.util.*

class Solution870 {
    fun advantageCount(A: IntArray, B: IntArray): IntArray {
        val a: Queue<IndexedValue<Int>> = LinkedList(A.withIndex().sortedBy { it.value })
        val b: Queue<IndexedValue<Int>> = LinkedList(B.withIndex().sortedBy { it.value })

        val dumped = mutableListOf<Int>()
        val index = IntArray(A.size){-1}
        while (true) {
            val bi = b.poll()
            var ai = a.poll()

            do {
                if (ai == null) {
                    break
                }
                if (ai.value > bi.value) {
                    index[bi.index] = ai.value
                    break
                } else {
                    dumped.add(ai.value)
                    ai = a.poll()
                }
            } while (true)

            if (ai == null)
                break
        }

        val iter = dumped.iterator()
        for (i in index.withIndex()) {
            if (i.value == -1) {
                index[i.index] = iter.next()
            }
        }

        return index
    }
}

fun main() {
    println(Solution870().advantageCount(intArrayOf(12,24,8,32), intArrayOf(13,25,32,11)).toList())
}