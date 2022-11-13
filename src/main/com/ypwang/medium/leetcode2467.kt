package com.ypwang.medium

class Solution2467 {
    fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
        val n = edges.size + 1
        val connections = Array(n) { mutableListOf<Int>() }
        val seen = BooleanArray(n)

        for ((i, j) in edges) {
            connections[i].add(j)
            connections[j].add(i)
        }

        // i: current node
        // d0: step from node 0 to node i
        // return:
        //   first: Alice's max income
        //   second: step from node Bob to node i (if not reachable, n)
        fun dfs(i: Int, d0: Int): Pair<Int, Int> {
            seen[i] = true
            var rst = Int.MIN_VALUE
            var db = if (i == bob) 0 else n
            for (j in connections[i]) {
                if (seen[j])
                    continue

                val (cur, kk) = dfs(j, d0+1)
                rst = maxOf(rst, cur)
                db = minOf(db, kk)
            }

            if (rst == Int.MIN_VALUE)
                rst = 0
            if (d0 == db)
                rst += amount[i] / 2
            if (d0 < db)
                rst += amount[i]

            return rst to db+1
        }

        return dfs(0, 0).first
    }
}