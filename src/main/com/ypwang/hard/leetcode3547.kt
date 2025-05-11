package com.ypwang.hard

import java.util.*

class Solution3547 {
    fun maxScore(n: Int, edges: Array<IntArray>): Long {
        val conn = Array(n) { mutableListOf<Int>() }
        for ((i, j) in edges) {
            conn[i].add(j)
            conn[j].add(i)
        }

        val seen = BooleanArray(n)

        fun getComp(i: Int): List<Int> {
            val bfs = mutableListOf(i)
            seen[i] = true
            var index = 0
            while (index < bfs.size) {
                val node = bfs[index++]
                for (neighbor in conn[node]) {
                    if (!seen[neighbor]) {
                        seen[neighbor] = true
                        bfs.add(neighbor)
                    }
                }
            }
            return bfs
        }

        val C = mutableListOf<Int>()
        val L = mutableListOf<Int>()

        for (i in 0 until n) {
            if (!seen[i]) {
                val comp = getComp(i)
                if (comp.all { conn[it].size == 2 })
                    C.add(comp.size)
                else if (comp.size > 1)
                    L.add(comp.size)
            }
        }

        fun calc(l: Int, r: Int, isCycle: Int): Long {
            val d: Deque<Int> = LinkedList()
            d.add(r)
            d.add(r)
            var res = 0L
            for (a in r - 1 downTo l) {
                val v = d.removeFirst()
                res += v.toLong() * a
                d.addLast(a)
            }
            return res + d.first.toLong() * d.last * isCycle
        }

        var score = 0L
        var currentN = n
        C.sortedDescending().forEach { k ->
            score += calc(currentN - k + 1, currentN, 1)
            currentN -= k
        }
        L.sortedDescending().forEach { k ->
            score += calc(currentN - k + 1, currentN, 0)
            currentN -= k
        }

        return score
    }
}
