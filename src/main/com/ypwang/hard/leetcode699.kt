package com.ypwang.hard

class Solution699 {
    class SegmentTree(val N: Int) {
        val H: Int
        val tree = IntArray(2 * N)
        val lazy = IntArray(N)

        init {
            var t = 1
            while (1 shl t < N)
                t++

            H = t
        }

        private fun apply(x: Int, `val`: Int) {
            tree[x] = maxOf(tree[x], `val`)
            if (x < N) lazy[x] = maxOf(lazy[x], `val`)
        }

        private fun pull(x: Int) {
            var y = x
            while (y > 1) {
                y = x shr 1
                tree[y] = maxOf(tree[y * 2], tree[y * 2 + 1])
                tree[y] = maxOf(tree[y], lazy[y])
            }
        }

        private fun push(x: Int) {
            for (h in H downTo 1) {
                val y = x shr h
                if (lazy[y] > 0) {
                    apply(y * 2, lazy[y])
                    apply(y * 2 + 1, lazy[y])
                    lazy[y] = 0
                }
            }
        }

        fun update(L: Int, R: Int, h:Int) {
            var l = L + N
            var r = R + N
            val l0 = l
            val r0 = R
            while (l <= r) {
                if (l and 1 == 1) apply(l++, h)
                if (r and 1 == 0) apply(r--, h)
                l = l shr 1
                r = r shr 1
            }
            pull(l0)
            pull(r0)
        }

        fun query(L: Int, R: Int): Int {
            var l = L + N
            var r = R + N
            var ans = 0
            push(l)
            push(r)
            while (l <= r) {
                if (l and 1 == 1) ans = maxOf(ans, tree[l++])
                if (r and 1 == 0) ans = maxOf(ans, tree[r--])
                l = l shr 1
                r = r shr 1
            }

            return ans
        }
    }

    fun fallingSquares(positions: Array<IntArray>): List<Int> {
        val xaxis = positions.flatMap { listOf(it[0], it[0] + it[1] - 1) }.toSet().toTypedArray()
        xaxis.sort()
        val reversed = xaxis.withIndex().map { it.value to it.index }.toMap()

        val tree = SegmentTree(xaxis.size)
        val ans = IntArray(positions.size)

        for ((i, pos) in positions.withIndex()) {
            val l = reversed[pos[0]]!!
            val r = reversed[pos[0] + pos[1] - 1]!!
            val h = tree.query(l, r) + pos[1]
            tree.update(l, r, h)
            ans[i] = h
            if (i > 0)
                ans[i] = maxOf(ans[i-1], ans[i])
        }
        return ans.toList()
    }
}