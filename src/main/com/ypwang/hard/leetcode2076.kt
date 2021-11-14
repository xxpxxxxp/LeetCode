package com.ypwang.hard

class Solution2076 {
    fun friendRequests(n: Int, restrictions: Array<IntArray>, requests: Array<IntArray>): BooleanArray {
        val dsu = IntArray(n) { it }

        fun root(i: Int): Int {
            if (i != dsu[i])
                dsu[i] = root(dsu[i])

            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            dsu[root(i)] = root(j)
        }

        val rst = BooleanArray(requests.size)
        for ((i, arr) in requests.withIndex()) {
            val (a, b) = arr
            val rs = setOf(root(a), root(b))
            var case = true
            for ((c, d) in restrictions) {
                if (root(c) in rs && root(d) in rs) {
                    case = false
                    break
                }
            }

            if (case && rs.size == 2) {
                val (e, f) = rs.toList()
                union(e, f)
            }

            rst[i] = case
        }

        return rst
    }
}