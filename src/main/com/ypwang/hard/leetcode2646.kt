package com.ypwang.hard

class Solution2646 {
    fun minimumTotalPrice(n: Int, edges: Array<IntArray>, price: IntArray, trips: Array<IntArray>): Int {
        val conn = Array(n) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            conn[a].add(b)
            conn[b].add(a)
        }

        fun dfsForPath(from: Int, cur: Int, dest: Int, path: MutableList<Int>): Boolean {
            path.add(cur)
            if (dest == cur)
                return true
            for (next in conn[cur]) {
                if (next == from)
                    continue
                if (dfsForPath(cur, next, dest, path))
                    return true
            }
            path.removeAt(path.lastIndex)
            return false
        }

        val nodeCount = IntArray(n)
        for (t in trips) {
            val path = mutableListOf<Int>()
            dfsForPath(-1, t[0], t[1], path)
            for (p in path) {
                nodeCount[p]++
            }
        }

        // ret[0] halve current
        // ret[1] not halve current
        fun dfs(from: Int, cur: Int): IntArray {
            val ret = intArrayOf(nodeCount[cur] * price[cur] / 2, nodeCount[cur] * price[cur])
            for (child in conn[cur]) {
                if (child == from)
                    continue

                val sub = dfs(cur, child)
                // if halve the current node, then the child cann't have the price.
                ret[0] += sub[1]
                // if doesn't halve current node, then the child can halve the price or not, we choose the min one.
                ret[1] += minOf(sub[0], sub[1])
            }
            return ret
        }

        return dfs(-1, 0).min()!!
    }
}
