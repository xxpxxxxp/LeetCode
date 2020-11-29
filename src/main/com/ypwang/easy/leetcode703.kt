package com.ypwang.easy

class heapK(val k: Int, nums: IntArray) {
    val ns = Array(k){ Int.MIN_VALUE }

    init {
        nums.forEach { store(it) }
    }

    fun store(n: Int) {
        if (n <= ns[0]) {
            return
        }

        ns[0] = n
        var i = 0
        while (2 * i + 1 < k) {
            val child = 2 * i + 1
            var swap = i
            if (ns[child] < ns[i]) {
                swap = child
            }
            if (child + 1 < k && ns[child + 1] < ns[swap]) {
                swap = child + 1
            }

            if (swap != i) {
                val tmp = ns[i]
                ns[i] = ns[swap]
                ns[swap] = tmp
                i = swap
            } else {
                return
            }
        }

    }

    fun top() = ns[0]
}

class KthLargest(k: Int, nums: IntArray) {
    val heap = heapK(k, nums)
    fun add(`val`: Int): Int {
        heap.store(`val`)
        return heap.top()
    }
}

fun main() {
    val k = KthLargest(3, intArrayOf(4, 5, 8, 2))
    for (i in intArrayOf(3,5,10,9,4))
        println(k.add(i))
}