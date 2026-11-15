package com.ypwang.medium

class Solution4112 {
    fun maxScore(parent: IntArray, op: IntArray, score: IntArray): Int {
        val n = parent.size
        val child = Array(n) { mutableListOf<Int>() }
        for (i in 1 until n)
            child[parent[i]].add(i)

        return dfs(0, child, op, score)
    }

    private fun dfs(i: Int, child: Array<MutableList<Int>>, op: IntArray, score: IntArray): Int {
        if (child[i].isEmpty())
            return score[i]

        var total = 0
        var mn = Int.MAX_VALUE
        for (j in child[i]) {
            val `val` = dfs(j, child, op, score)
            total += `val`
            if (`val` < mn)
                mn = `val`
        }
        if (op[i] == 1 || mn < 0)
            total -= mn

        return score[i] + total
    }
}
