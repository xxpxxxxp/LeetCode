package com.ypwang.medium

import java.util.*

class Solution1738 {
    fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
        val heap = PriorityQueue<Int>()
        for ((i, row) in matrix.withIndex()) {
            for ((j, c) in row.withIndex()) {
                var r = c
                if (i > 0)
                    r = r xor matrix[i-1][j]

                if (j > 0)
                    r = r xor matrix[i][j-1]

                if (i > 0 &&j > 0)
                    r = r xor matrix[i-1][j-1]

                matrix[i][j] = r
                heap.offer(r)
                if (heap.size > k)
                    heap.poll()
            }
        }

        return heap.poll()
    }
}