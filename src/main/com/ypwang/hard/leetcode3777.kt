package com.ypwang.hard

class Solution3777 {
    class FenwickTree(size: Int) {
        private val tree: IntArray = IntArray(size + 1)

        fun add(i: Int, delta: Int) {
            var i = i
            while (i < tree.size) {
                tree[i] += delta
                i += i and -i
            }
        }

        fun query(i: Int): Int {
            var i = i
            var s = 0
            while (i > 0) {
                s += tree[i]
                i -= i and -i
            }
            return s
        }
    }

    fun minDeletions(s: String, queries: Array<IntArray>): IntArray {
        val n = s.length
        val A = IntArray(n)
        for (i in 0 until n) {
            A[i] = s[i] - 'A'
        }

        val bit = FenwickTree(n)
        for (i in 0 until n - 1)
            if (A[i] == A[i + 1])
                bit.add(i + 1, 1)

        val res = mutableListOf<Int>()
        for (q in queries) {
            if (q[0] == 1) {
                val i = q[1]
                A[i] = A[i] xor 1
                if (i > 0)
                    bit.add(i, if (A[i] == A[i - 1]) 1 else -1)
                if (i < n - 1)
                    bit.add(i + 1, if (A[i] == A[i + 1]) 1 else -1)
            } else
                res.add(bit.query(q[2]) - bit.query(q[1]))
        }

        return res.toIntArray()
    }
}
