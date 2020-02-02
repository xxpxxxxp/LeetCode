package com.ypwang.hard

class Solution699 {
    class SegmentTree(val N: Int) {
        private val size: Int
        private val tree: IntArray
        private val lazy: IntArray

        init {
            var t = 1
            while (t < N)
                t = t shl 1

            size = t
            tree = IntArray(2 * size)
            lazy = IntArray(2 * size)
        }

        private fun update(idx: Int, lo: Int, hi: Int, i: Int, j: Int, `val`: Int) {
            if (lo >= hi || lo >= j || hi <= i) return
            tree[idx] = maxOf(tree[idx], `val`)
            if (i <= lo && hi <= j) {
                if (lo + 1 != hi) {
                    lazy[2 * idx + 1] = `val`
                    lazy[2 * idx + 2] = `val`
                }
                return
            }

            val mid = (lo + hi) / 2
            update(2 * idx + 1, lo, mid, i, j, `val`)
            update(2 * idx + 2, mid, hi, i, j, `val`)
        }

        fun update(L: Int, R: Int, h:Int) = update(0, 0, size, L, R, h)

        private fun query(idx: Int, lo: Int, hi: Int, i: Int, j: Int): Int {
            if (lo >= j || hi <= i) return 0

            if (lazy[idx] != 0) {
                tree[idx] = lazy[idx]
                if (lo + 1 != hi) {
                    lazy[2 * idx + 1] = lazy[idx]
                    lazy[2 * idx + 2] = lazy[idx]
                }

                lazy[idx] = 0
            }

            if (i <= lo && hi <= j) return tree[idx]

            val mid = (lo + hi) / 2
            return when {
                i >= mid -> query(2 * idx + 2, mid, hi, i, j)
                j < mid -> query(2 * idx + 1, lo, mid, i, j)
                else -> {
                    val lq = query(2 * idx + 1, lo, mid, i, mid)
                    val rq = query(2 * idx + 2, mid, hi, mid, j)
                    maxOf(lq, rq)
                }
            }
        }

        fun query(L: Int, R: Int): Int = query(0, 0, size, L, R)
    }

    fun fallingSquares(positions: Array<IntArray>): List<Int> {
        val xaxis = positions.flatMap { listOf(it[0], it[0] + it[1]) }.toSet().toTypedArray()
        xaxis.sort()
        val reversed = xaxis.withIndex().map { it.value to it.index }.toMap()

        val tree = SegmentTree(xaxis.size)
        val ans = IntArray(positions.size)

        for ((i, pos) in positions.withIndex()) {
            val l = reversed[pos[0]]!!
            val r = reversed[pos[0] + pos[1]]!!
            val h = tree.query(l, r) + pos[1]
            tree.update(l, r, h)
            ans[i] = h
            if (i > 0)
                ans[i] = maxOf(ans[i-1], ans[i])
        }
        return ans.toList()
    }
}

fun main() {
    println(Solution699().fallingSquares(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(6,1))))
    println(Solution699().fallingSquares(arrayOf(intArrayOf(100,100), intArrayOf(200,100))))
}