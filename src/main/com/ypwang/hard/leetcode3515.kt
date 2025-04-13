package com.ypwang.hard

// Fenwick Tree (Binary Indexed Tree) implementation
class Fenwick(val n: Int) {
    private val BIT = LongArray(n + 1) { 0L }

    fun update(i0: Int, delta: Long) {
        var i = i0
        while (i <= n) {
            BIT[i] += delta
            i += i and -i
        }
    }

    fun query(i0: Int): Long {
        var i = i0
        var sum = 0L
        while (i > 0) {
            sum += BIT[i]
            i -= i and -i
        }
        return sum
    }
}

// Tree structure with DFS preprocessing
class Tree(val N: Int) {
    var root = 1
    val adj = Array(N + 1) { mutableListOf<Pair<Int, Int>>() }
    val tin = IntArray(N + 1)
    val tout = IntArray(N + 1)
    val par = IntArray(N + 1)
    val depth = IntArray(N + 1)
    val rootD = LongArray(N + 1)
    var timer = 0

    fun addEdge(u: Int, v: Int, w: Int) {
        adj[u].add(Pair(v, w))
        adj[v].add(Pair(u, w))
    }

    fun init(rt: Int = 1) {
        root = rt
        timer = 0

        fun dfs(u: Int, p: Int, dist: Long) {
            par[u] = p
            rootD[u] = dist
            tin[u] = ++timer
            depth[u] = depth[p] + 1
            for ((v, w) in adj[u]) {
                if (v != p) {
                    dfs(v, u, dist + w)
                }
            }
            tout[u] = timer
        }

        dfs(root, 0, 0L)
    }
}

// Solution class equivalent
class Solution3515 {
    fun treeQueries(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val tree = Tree(n)
        val ans = mutableListOf<Int>()

        edges.forEach { (a,b,c) -> tree.addEdge(a,b,c) }
        tree.init(1)

        val F = Fenwick(tree.timer)
        val up = IntArray(n + 1)

        for (i in 2..n)
            for ((u, w) in tree.adj[i])
                if (u == tree.par[i])
                    up[i] = w

        for (q in queries) {
            if (q[0] == 1) {
                val u = q[1]
                val v = q[2]
                var c = v
                if (tree.par[u] == v) c = u
                val delta = q[3] - up[c]
                F.update(tree.tin[c], delta.toLong())
                F.update(tree.tout[c] + 1, -delta.toLong())
                up[c] = q[3]
            } else {
                val result = tree.rootD[q[1]] + F.query(tree.tin[q[1]])
                ans.add(result.toInt())
            }
        }

        return ans.toIntArray()
    }
}
