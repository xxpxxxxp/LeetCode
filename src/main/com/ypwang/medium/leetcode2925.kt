package com.ypwang.medium

class Solution2925 {
    fun maximumScoreAfterOperations(edges: Array<IntArray>, values: IntArray): Long {
        val conn = Array(edges.size + 1) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            conn[a].add(b)
            conn[b].add(a)
        }

        // return:
        // 1. max value we can get when we ensure the condition
        // 2. full tree sum

        // 2 way:
        // sub tree ensure the condition, we take the node value
        // we take full sub tree, leave the node value
        fun helper(from: Int, cur: Int): Pair<Long, Long> {
            if (conn[cur].size == 1 && conn[cur].first() == from)
                return 0L to values[cur].toLong()

            var rst = 0L
            var sum = 0L
            for (n in conn[cur]) {
                if (n == from)
                    continue

                val (r, s) = helper(cur, n)
                rst += r
                sum += s
            }

            return maxOf(values[cur] + rst, sum) to sum + values[cur]
        }

        return helper(-1, 0).first
    }
}