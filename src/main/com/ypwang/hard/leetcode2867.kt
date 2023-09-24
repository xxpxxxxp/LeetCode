package com.ypwang.hard

class Solution2867 {
    fun countPaths(n: Int, edges: Array<IntArray>): Long {
        val prime = BooleanArray(n + 1) { true }
        prime[1] = false
        val all = mutableListOf<Int>()
        for (i in 2..n) {
            if (prime[i])
                all.add(i)
            for (j in i..(n/i))
                prime[i * j] = false
        }
        val conn = Array(n+1) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            conn[a].add(b)
            conn[b].add(a)
        }

        fun dfs(father: Int, x: Int): Triple<Long, Long, Long> {
            var (c0, c1) =
                if (prime[x])
                    0L to 1L
                else
                    1L to 0L

            var rst = 0L
            for (y in conn[x]) {
                if (y == father)
                    continue
                val (n0, n1, nr) = dfs(x, y)
                rst += nr + n0 * c1 + n1 * c0
                if (prime[x])
                    c1 += n0
                else {
                    c0 += n0
                    c1 += n1
                }
            }
            return Triple(c0, c1, rst)
        }

        return dfs(0, 1).third
    }
}
