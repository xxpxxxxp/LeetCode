package com.ypwang.medium

class Solution373 {
    private class heap(initial: Array<Triple<Int, Int, Int>>) {
        val inner = initial
        var size = inner.size
        init {
            var start = size / 2 - 1
            while (start >= 0) {
                shiftDown(start, size)
                start--
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

    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<IntArray> {
        if (nums1.isEmpty() || nums2.isEmpty()) return listOf()

        val h = heap(Array(nums1.size){ Triple(it, 0, nums1[it] + nums2[0]) })
        val rst = mutableListOf<IntArray>()

        while (rst.size < k) {
            val t = h.head()
            if (t == null) break
            else {
                rst.add(intArrayOf(nums1[t.first], nums2[t.second]))
                if (t.second + 1 < nums2.size) h.replaceHead(Triple(t.first, t.second+1, nums1[t.first] + nums2[t.second+1]))
                else h.shrink()
            }
        }

        return rst
    }
}

fun main() {
    println(Solution373().kSmallestPairs(intArrayOf(0,0,0,0,0,2,2,2,2), intArrayOf(-3,22,35,56,76), 22).map { it.toList() })
}