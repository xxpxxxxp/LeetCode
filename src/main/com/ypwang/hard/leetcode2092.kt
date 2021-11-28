package com.ypwang.hard

class Solution2092 {
    class DSU(n: Int) {
        val inner = IntArray(n) { it }

        fun root(i: Int): Int {
            if (inner[i] != i)
                inner[i] = root(inner[i])

            return inner[i]
        }

        fun union(i: Int, j: Int) {
            inner[root(i)] = root(j)
        }
    }

    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> =
        meetings.groupBy { it[2] }.toList().sortedBy { it.first }.map { it.second }.fold(mutableSetOf(0, firstPerson)) { knows, grid ->
            val seen = mutableSetOf<Int>()
            val dsu = DSU(n)
            for ((a, b, _) in grid) {
                dsu.union(a, b)
                seen.add(a)
                seen.add(b)
            }

            val groups = mutableMapOf<Int, MutableList<Int>>()
            for (i in seen)
                groups.getOrPut(dsu.root(i), { mutableListOf() }).add(i)

            for ((_, list) in groups) {
                if (list.intersect(knows).isNotEmpty())
                    knows.addAll(list)
            }

            knows
        }.toList()
}