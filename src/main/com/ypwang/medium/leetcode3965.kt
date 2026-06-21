package com.ypwang.medium

class Solution3965 {
    fun finishTime(n: Int, edges: Array<IntArray>, baseTime: IntArray): Long {
        val tree = mutableMapOf<Int, MutableList<Int>>()
        for ((a, b) in edges) {
            tree.getOrPut(a, { mutableListOf() }).add(b)
        }
        return calculateTime(tree, 0, baseTime)
    }

    private fun calculateTime(tree: Map<Int, MutableList<Int>>, currNode: Int, baseTime: IntArray): Long {
        if (tree.getOrDefault(currNode, null) == null)
            return baseTime[currNode].toLong()

        var earliest = Long.MAX_VALUE
        var latest = Long.MIN_VALUE
        for (i in tree[currNode]!!.indices) {
            val time = calculateTime(tree, tree.get(currNode)!!.get(i)!!, baseTime)
            earliest = minOf(earliest, time)
            latest = maxOf(latest, time)
        }

        return latest + (latest - earliest) + baseTime[currNode]
    }
}
