package com.ypwang.hard

import java.util.*

class Solution1439 {
    fun kthSmallest(mat: Array<IntArray>, k: Int): Int =
        mat.fold(PriorityQueue<Int>().apply { this.add(0) }){ l, row ->
            val heap = PriorityQueue<Int>{ a, b -> b.compareTo(a) }

            for (i in l) {
                for (j in row) {
                    heap.add(i + j)
                    if (heap.size > k)
                        heap.poll()
                }
            }

            heap
        }.maxOrNull()!!
}