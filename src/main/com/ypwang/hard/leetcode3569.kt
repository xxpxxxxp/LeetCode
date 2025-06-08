package com.ypwang.hard

import java.util.*

class Solution3569 {
    private val isPrime = BooleanArray(100001) { true }

    init {
        isPrime[0] = false
        isPrime[1] = false
        var i = 2
        while (i * i < isPrime.size) {
            if (isPrime[i]) {
                var j = i * i
                while (j < isPrime.size) {
                    isPrime[j] = false
                    j += i
                }
            }
            i++
        }
    }

    class SegmentTree(n: Int) {
        var sum: IntArray
        var max: IntArray
        var size: Int = 1

        init {
            while (size < n + 2)
                size = size shl 1
            sum = IntArray(2 * size)
            max = IntArray(2 * size)
        }

        fun pointAdd(pos: Int, delta: Int) {
            var i = pos + size
            sum[i] += delta
            max[i] = maxOf(sum[i], 0)
            i = i shr 1
            while (i > 0) {
                sum[i] = sum[2 * i] + sum[2 * i + 1]
                max[i] = maxOf(max[2 * i], sum[2 * i] + max[2 * i + 1])
                i = i shr 1
            }
        }

        fun applyRange(from: Int, to: Int, delta: Int) {
            if (from + 1 <= to) {
                pointAdd(from + 1, delta)
                pointAdd(to + 1, -delta)
            }
        }

        fun getMax(): Int {
            return max[1]
        }
    }

    fun maximumCount(nums: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums.size

        val segTree = SegmentTree(n)
        val primeIndices = HashMap<Int, TreeSet<Int>>()

        // Initialize
        for (i in 0 until n) {
            val v = nums[i]
            if (isPrime[v])
                primeIndices.computeIfAbsent(v) { TreeSet<Int>() }.add(i)
        }

        for (set in primeIndices.values) {
            val first: Int = set.first()!!
            val last: Int = set.last()!!
            segTree.applyRange(first, last, +1)
        }
        var distinct = primeIndices.size

        val result = IntArray(queries.size)
        for (q in queries.indices) {
            val (idx, `val`) = queries[q]
            val old = nums[idx]

            if (old == `val`) {
                result[q] = distinct + segTree.getMax()
                continue
            }

            // Remove old value
            if (isPrime[old]) {
                val set = primeIndices[old]!!
                val f1 = set.first()!!
                val l1 = set.last()!!
                segTree.applyRange(f1, l1, -1)
                set.remove(idx)
                if (set.isEmpty()) {
                    primeIndices.remove(old)
                    distinct--
                } else {
                    val f2 = set.first()!!
                    val l2 = set.last()!!
                    segTree.applyRange(f2, l2, +1)
                }
            }

            // Add new value
            if (isPrime[`val`]) {
                if (!primeIndices.containsKey(`val`)) {
                    val set = TreeSet<Int>()
                    set.add(idx)
                    primeIndices.put(`val`, set)
                    segTree.applyRange(idx, idx, +1)
                    distinct++
                } else {
                    val set = primeIndices[`val`]!!
                    val f1 = set.first()!!
                    val l1 = set.last()!!
                    segTree.applyRange(f1, l1, -1)
                    set.add(idx)
                    val f2 = set.first()!!
                    val l2 = set.last()!!
                    segTree.applyRange(f2, l2, +1)
                }
            }

            nums[idx] = `val`
            result[q] = distinct + segTree.getMax()
        }

        return result
    }
}
