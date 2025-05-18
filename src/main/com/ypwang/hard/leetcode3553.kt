package com.ypwang.hard

import kotlin.math.log2

class Solution3553 {
    fun dfs(
        u: Int,
        par: Int,
        lvl: Int,
        wt: Int,
        levels: IntArray,
        weights: IntArray,
        graph: List<List<Pair<Int, Int>>>,
        LCA: Array<IntArray>,
    ) {
        levels[u] = lvl
        weights[u] = wt
        LCA[u][0] = par

        for ((v, w) in graph[u])
            if (v != par)
                dfs(v, u, lvl + 1, wt + w, levels, weights, graph, LCA)
    }

    fun init(n: Int, maxN: Int, LCA: Array<IntArray>) {
        for (i in 1..maxN) {
            for (j in 0 until n) {
                if (LCA[j][i - 1] != -1) {
                    val par = LCA[j][i - 1]
                    LCA[j][i] = LCA[par][i - 1]
                }
            }
        }
    }

    fun findLCA(
        a: Int,
        b: Int,
        maxN: Int,
        levels: IntArray,
        LCA: Array<IntArray>,
    ): Int {
        var nodeA = a
        var nodeB = b

        if (levels[nodeA] > levels[nodeB]) {
            nodeA = b
            nodeB = a
        }

        var jumpD = levels[nodeB] - levels[nodeA]
        while (jumpD > 0) {
            val jump = Math.floor(log2(jumpD.toDouble())).toInt()
            nodeB = LCA[nodeB][jump]
            jumpD -= (1 shl jump)
        }

        if (nodeA == nodeB) return nodeA

        for (i in maxN downTo 0) {
            if (LCA[nodeA][i] != -1 && LCA[nodeA][i] != LCA[nodeB][i]) {
                nodeA = LCA[nodeA][i]
                nodeB = LCA[nodeB][i]
            }
        }
        return LCA[nodeA][0]
    }

    fun getDistance(
        u: Int,
        v: Int,
        maxN: Int,
        levels: IntArray,
        weights: IntArray,
        LCA: Array<IntArray>,
    ): Int =
        weights[u] + weights[v] - 2 * weights[findLCA(u, v, maxN, levels, LCA)]

    fun minimumWeight(edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val n = edges.size + 1
        val m = queries.size

        val graph =
            MutableList(n) { mutableListOf<Pair<Int, Int>>() }
        for ((u, v, w) in edges) {
            graph[u].add(Pair(v, w))
            graph[v].add(Pair(u, w))
        }

        val maxN = if (n > 1) Math.floor(log2(n.toDouble())).toInt() else 0

        val levels = IntArray(n) { 0 }
        val weights = IntArray(n) { 0 }
        val LCA = Array(n) { IntArray(maxN + 1) { -1 } }

        dfs(0, -1, 0, 0, levels, weights, graph, LCA)

        init(n, maxN, LCA)

        val ans = IntArray(m) { 0 }
        for (i in 0 until m) {
            val (src1, src2, dest) = queries[i]
            ans[i] = (getDistance(src1, dest, maxN, levels, weights, LCA) +
                    getDistance(src2, dest, maxN, levels, weights, LCA) +
                    getDistance(src1, src2, maxN, levels, weights, LCA)) / 2
        }

        return ans
    }
}
