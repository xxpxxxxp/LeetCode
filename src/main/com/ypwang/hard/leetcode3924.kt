package com.ypwang.hard

class Solution3924 {
    fun minimumThreshold(n: Int, edges: Array<IntArray>, source: Int, target: Int, k: Int): Int {
        val adj = HashMap<Int, MutableList<Pair<Int, Int>>>()

        for ((u, v, w) in edges) {
            adj.computeIfAbsent(u) { mutableListOf() }.add(Pair(v, w))
            adj.computeIfAbsent(v) { mutableListOf() }.add(Pair(u, w))
        }

        fun isValid(mid: Int): Boolean {
            val result = IntArray(n) { Int.MAX_VALUE }
            val q  = ArrayDeque<Pair<Int, Int>>()

            q.add(Pair(source, 0))
            result[source] = 0

            while (q.isNotEmpty()) {
                val (cur, count) = q.removeFirst()

                for ((next, weight) in adj.getOrDefault(cur, emptyList())) {
                    val newCount = count + if (weight > mid) 1 else 0

                    if (result[next] > newCount) {
                        result[next] = newCount
                        q.add(Pair(next, newCount))
                    }
                }
            }

            return result[target] != Int.MAX_VALUE && result[target] <= k
        }

        var l = 0
        var r = 1000000000
        var rst = -1
        while (l <= r) {
            val mid = (l + r) / 2

            if (isValid(mid)) {
                rst = mid
                r = mid - 1
            } else
                l = mid + 1
        }

        return rst
    }
}
