package com.ypwang.hard

class Solution3203 {
    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
        fun farthest(conn: Array<MutableList<Int>>, i: Int): Pair<Int, Int> {
            val n = conn.size
            val bfs = mutableListOf<Int>()
            val seen = IntArray(n) { 0 }
            seen[i] = 1
            bfs.add(i)
            var res = -1
            var maxd = -1
            while (bfs.isNotEmpty()) {
                val current = bfs.removeFirst()
                for (j in conn[current]) {
                    if (seen[j] == 0) {
                        seen[j] = seen[current] + 1
                        bfs.add(j)
                        if (seen[j] > maxd) {
                            res = j
                            maxd = seen[j]
                        }
                    }
                }
            }
            return Pair(res, maxd - 1)
        }

        fun diameter(edges: Array<IntArray>): Triple<Int, Int, Int> {
            if (edges.isEmpty())
                return Triple(0, 0, 0)

            val conn = Array(edges.size+1) { mutableListOf<Int>() }
            for ((a, b) in edges) {
                conn[a].add(b)
                conn[b].add(a)
            }
            val (v1, _) = farthest(conn, 0)
            val (v2, d) = farthest(conn, v1)
            return Triple(d, v1, v2)
        }

        val (d1, _, _) = diameter(edges1)
        val (d2, _, _) = diameter(edges2)
        return maxOf(d1, d2, (d1 + 1) / 2 + (d2 + 1) / 2 + 1)
    }
}
