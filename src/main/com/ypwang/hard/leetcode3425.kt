package com.ypwang.hard

class Solution3425 {
    fun longestSpecialPath(edges: Array<IntArray>, nums: IntArray): IntArray {
        val al = Array(nums.size) { mutableListOf<Pair<Int, Int>>() }
        for ((a, b, l) in edges) {
            al[a].add(Pair(b, l))
            al[b].add(Pair(a, l))
        }

        var res = intArrayOf(0, 1)
        val depth = IntArray(50001) { -1 }

        fun dfs(cur: Int, parent: Int, left: Int, curDepth: Int, preSum: MutableList<Int>) {
            val prevDepth = depth[nums[cur]]
            depth[nums[cur]] = curDepth

            var newLeft = maxOf(left, prevDepth)
            val t = preSum[newLeft] - preSum.last()
            if (t < res[0] || (t == res[0] && curDepth - newLeft < res[1]))
                res = intArrayOf(t, curDepth - newLeft)

            for ((j, l) in al[cur])
                if (j != parent) {
                    preSum.add(preSum.last() + l)
                    dfs(j, cur, newLeft, curDepth + 1, preSum)
                    preSum.removeAt(preSum.size - 1)
                }

            depth[nums[cur]] = prevDepth
        }

        dfs(0, -1, 0, 1, mutableListOf(0))
        return intArrayOf(-res[0], res[1])
    }
}
