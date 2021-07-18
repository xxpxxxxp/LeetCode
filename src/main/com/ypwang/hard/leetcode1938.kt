package com.ypwang.hard

class Solution1938 {
    class TrieNode {
        private var child = arrayOfNulls<TrieNode>(2)
        private var cnt = 0

        fun increase(number: Int, d: Int) {
            var cur = this
            for (i in 17 downTo 0) {
                val bit = number shr i and 1
                if (cur.child[bit] == null)
                    cur.child[bit] = TrieNode()

                cur = cur.child[bit]!!
                cur.cnt += d
            }
        }

        fun findMax(number: Int): Int {
            var cur: TrieNode = this
            var ans = 0
            for (i in 17 downTo 0) {
                val bit = number shr i and 1
                if (cur.child[1 - bit] != null && cur.child[1 - bit]!!.cnt > 0) {
                    cur = cur.child[1 - bit]!!
                    ans = ans or (1 shl i)
                } else
                    cur = cur.child[bit]!!
            }
            return ans
        }
    }

    fun maxGeneticDifference(parents: IntArray, qs: Array<IntArray>): IntArray {
        val trieRoot = TrieNode()
        val m = qs.size
        val n = parents.size
        var root = -1
        val graph = Array(n){ mutableListOf<Int>() }
        for (i in 0 until n)
            if (parents[i] == -1)
                root = i
            else
                graph[parents[i]].add(i)

        val queryByNode = Array(n){ mutableListOf<IntArray>() }
        for (i in 0 until m)
            // node -> list of pairs (val, idx)
            queryByNode[qs[i][0]].add(intArrayOf(qs[i][1], i))

        fun dfs(u: Int, ans: IntArray) {
            trieRoot.increase(u, 1)

            for ((`val`, idx) in queryByNode[u])
                ans[idx] = trieRoot.findMax(`val`)

            for (v in graph[u])
                dfs(v, ans)

            trieRoot.increase(u, -1)
        }

        val ans = IntArray(m)
        dfs(root, ans)
        return ans
    }
}

fun main() {
    println(Solution1938().maxGeneticDifference(intArrayOf(-1,0,1,1), arrayOf(
        intArrayOf(0,2),intArrayOf(3,2),intArrayOf(2,5)
    )).toList())
}