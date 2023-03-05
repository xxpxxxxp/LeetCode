package com.ypwang.hard

class Solution2581 {
    fun rootCount(edges: Array<IntArray>, guesses: Array<IntArray>, k: Int): Int {
        val n = edges.size + 1
        val parents = IntArray(n)
        val tree = Array(n) { mutableListOf<Int>() }
        val guessGraph = Array(n) { mutableSetOf<Int>() }

        for ((a, b) in edges) {
            tree[a].add(b)
            tree[b].add(a)
        }
        for ((a, b) in guesses)
            guessGraph[a].add(b)

        fun fillParent(node: Int, parent: Int) {
            parents[node] = parent
            for (child in tree[node]) {
                if (child == parent)
                    continue
                fillParent(child, node)
            }
        }

        fillParent(0, -1)

        var correctGuesses = 0
        for (i in 1 until n) {
            if (i in guessGraph[parents[i]])
                correctGuesses++
        }

        var rst = 0
        if (correctGuesses >= k)
            rst++

        fun dfs(node: Int, parent: Int, correctGuesses1: Int) {
            var cur = correctGuesses1
            if (node in guessGraph[parent])
                cur--
            if (parent in guessGraph[node])
                cur++
            if (cur >= k)
                rst++
            for (child in tree[node]) {
                if (child != parent)
                    dfs(child, node, cur)
            }
        }

        for (c in tree[0])
            dfs(c, 0, correctGuesses)

        return rst
    }
}