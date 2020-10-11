package com.ypwang.hard

class Solution1617 {
    fun countSubgraphsForEachDiameter(n: Int, edges: Array<IntArray>): IntArray {
        fun bfs(from: Int, graph: Map<Int, MutableList<Int>>): Triple<Int, Int, Set<Int>> {
            var count = 0
            val visited = mutableSetOf<Int>()
            var farthest = -1
            var current = listOf(from)

            while (current.isNotEmpty()) {
                farthest = current.first()

                visited.addAll(current)
                val next = mutableListOf<Int>()
                for (i in current)
                    if (i in graph)
                        next.addAll(graph[i]!!.subtract(visited))

                count++
                current = next
            }

            return Triple(farthest, count-1, visited)
        }

        fun diameterOfTree(cities: Set<Int>, graph: Map<Int, MutableList<Int>>): Int {
            val (farthest, _, visited) = bfs(cities.first(), graph)
            if (visited.size != cities.size)
                return 0

            return bfs(farthest, graph).second
        }

        fun maxDistance(state: Int): Int {
            val cities = (0 until n).filter { state and (1 shl it) > 0 }.toSet()
            val graph = mutableMapOf<Int, MutableList<Int>>()

            for ((u, v) in edges) {
                if (u-1 in cities && v-1 in cities) {
                    graph.getOrPut(u-1, { mutableListOf() }).add(v-1)
                    graph.getOrPut(v-1, { mutableListOf() }).add(u-1)
                }
            }

            return diameterOfTree(cities, graph)
        }

        val rst = IntArray(n-1)
        (1 until (1 shl n)).forEach {
            val d = maxDistance(it)
            if (d > 0)
                rst[d-1]++
        }
        return rst
    }
}

fun main() {
    println(Solution1617().countSubgraphsForEachDiameter(4, arrayOf(
            intArrayOf(1,2), intArrayOf(2,3), intArrayOf(2,4)
    )).toList())
}