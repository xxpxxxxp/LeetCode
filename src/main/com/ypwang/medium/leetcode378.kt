package com.ypwang.medium

class Solution378 {
    private class heap(initial: Array<Triple<Int, Int, Int>>) {
        val inner = initial
        var size = inner.size
        init {
            for (start in (size / 2 - 1) downTo 0) {
                shiftDown(start, size)
            }
        }

        fun shiftDown(idx: Int, end: Int) {
            var root = idx
            while (2 * root + 1 < end) {
                var swap = root
                if (inner[swap].third > inner[2 * root + 1].third)
                    swap = 2 * root + 1

                if (2 * root + 2 < end && inner[swap].third > inner[2 * root + 2].third)
                    swap = 2 * root + 2

                if (swap != root) {
                    val t = inner[root]
                    inner[root] = inner[swap]
                    inner[swap] = t
                    root = swap
                } else break
            }
        }

        fun head(): Triple<Int, Int, Int>? {
            return if (size > 0) inner.first() else null
        }

        fun replaceHead(item: Triple<Int, Int, Int>) {
            inner[0] = item
            shiftDown(0, size)
        }

        fun shrink() {
            size -= 1
            inner[0] = inner[size]
            shiftDown(0, size)
        }
    }

    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val initial = matrix.withIndex().map { Triple(it.index, 0, it.value[0]) }.toTypedArray()
        val heap = heap(initial)

        var count = 0
        while (true) {
            val t = heap.head()!!
            count++
            if (count == k) return t.third

            if (t.second < matrix[0].lastIndex) heap.replaceHead(Triple(t.first, t.second+1, matrix[t.first][t.second+1]))
            else heap.shrink()
        }
    }
}

fun main() {
    println(Solution378().kthSmallest(arrayOf(
            intArrayOf(1, 5, 9), intArrayOf(10, 11, 13), intArrayOf(12, 13, 15)
    ), 8))
}