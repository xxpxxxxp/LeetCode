package com.ypwang.hard

class Solution3486 {
    fun longestSpecialPath(edges: Array<IntArray>, nums: IntArray): IntArray {
        var ans = intArrayOf(0, 1)
        val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        for ((a, b, c) in edges) {
            graph.getOrPut(a) { mutableListOf() }.add(Pair(b, c))
            graph.getOrPut(b) { mutableListOf() }.add(Pair(a, c))
        }

        val costs = mutableListOf<Int>()
        val last = mutableMapOf<Int, Int>()

        fun dfs(node: Int, currCost: Int, prev: Int, left: MutableList<Int>) {
            val nodeColorIndexPrev = last.getOrDefault(nums[node], -1)
            last[nums[node]] = costs.size
            costs.add(currCost)

            val ans2 = intArrayOf(currCost - costs[left[0]], costs.size - left[0])
            ans = listOf(ans, ans2).maxWith(compareBy({ it[0] }, { -it[1] }))

            for ((nextNode, nextCost) in graph.getOrDefault(node, emptyList())) {
                if (nextNode == prev)
                    continue

                val nextLeft = left.toMutableList()
                last[nums[nextNode]]?.let { if (it != -1) nextLeft.add(it + 1) }

                dfs(nextNode, currCost + nextCost, node, nextLeft.sorted().takeLast(2).toMutableList())
            }

            last[nums[node]] = nodeColorIndexPrev
            costs.removeAt(costs.size - 1)
        }

        dfs(0, 0, -1, mutableListOf(0, 0))
        return ans
    }
}
