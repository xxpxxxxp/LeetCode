package com.ypwang.medium

class NumArray(nums: IntArray) {
    private var cap = 0
    private var heap: IntArray

    init {
        var c = 0
        var size = nums.size
        while (size > 0) {
            size = size shr 1
            c++
        }

        cap = (1 shl c) - 1
        heap = IntArray(2 * cap + 1)
        for (i in cap until cap + nums.size) {
            heap[i] = nums[i - cap]
        }

        for (i in cap - 1 downTo 0) {
            heap[i] = heap[2 * i + 1] + heap[2 * i + 2]
        }
    }

    fun update(i: Int, `val`: Int) {
        var idx = i + cap
        val inc = `val` - heap[idx]
        while (true) {
            heap[idx] = heap[idx] + inc
            if (idx == 0) break
            idx = (idx - 1) / 2
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        fun helper(rl: Int, rr: Int, idx: Int): Int {
            if (j < rl || i > rr) return 0
            if (i <= rl && j >= rr) return heap[idx]
            // break down
            return helper(rl, (rr + rl) / 2, 2 * idx + 1) + helper((rr + rl + 1) / 2, rr, 2 * idx + 2)
        }

        return helper(0, cap, 0)
    }
}

fun main() {
    val t = NumArray(intArrayOf(1,3,5))
    println(t.sumRange(0,2))
    t.update(1,2)
    println(t.sumRange(0,2))
}