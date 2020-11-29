package com.ypwang

fun heapsort(n: IntArray) {
    fun siftDown(n: IntArray, start: Int, end: Int) {
        var root = start
        while (2 * root + 1 <= end) {
            val child = 2 * root + 1
            var swap = root
            if (n[swap] < n[child]) {
                swap = child
            }
            if (child + 1 <= end && n[swap] < n[child + 1]) {
                swap = child + 1
            }
            if (swap == root) {
                return
            } else {
                val tmp = n[root]
                n[root] = n[swap]
                n[swap] = tmp
                root = swap
            }
        }
    }

    fun heapify(n: IntArray) {
        var start = (n.lastIndex - 1) / 2
        while (start >= 0) {
            siftDown(n, start, n.lastIndex)
            start -= 1
        }
    }

    heapify(n)
    var end = n.lastIndex
    while (end > 0) {
        val tmp = n[0]
        n[0] = n[end]
        n[end] = tmp
        end -= 1
        siftDown(n, 0, end)
    }
}

fun main() {
    println(heapsort(intArrayOf(5,2,7,3,2,7,4,1,7,3,5,8,4,3,7)))
}