package com.ypwang.hard

import java.util.PriorityQueue

class Solution2699 {
    fun modifiedGraphEdges(n: Int, edges: Array<IntArray>, source: Int, destination: Int, target: Int): Array<IntArray> {
        val conn = Array(n) { mutableMapOf<Int, Int>() }
        for ((a,b,w) in edges) {
            conn[a][b] = w
            conn[b][a] = w
        }
        val distTo = IntArray(n) { Int.MAX_VALUE }
        distTo[source] = 0
        val pq = PriorityQueue<IntArray>(compareBy { it[1] })
        pq.add(intArrayOf(source, 0))

        dijkstra(conn, distTo, pq)

        if (distTo[destination] == target) {
            return fill(edges)
        } else if (distTo[destination] < target) {
            return arrayOf()
        } else {
            for (edge in edges) {
                val (a,b,w) = edge
                if (w == -1) {
                    edge[2] = 1
                    conn[a][b] = 1
                    conn[b][a] = 1
                    pq.clear()
                    pq.add(intArrayOf(a, distTo[a]))
                    pq.add(intArrayOf(b, distTo[b]))

                    dijkstra(conn, distTo, pq)

                    if (distTo[destination] <= target) {
                        edge[2] += target - distTo[destination]
                        return fill(edges)
                    }
                }
            }
        }
        return arrayOf()
    }

    private fun fill(edges: Array<IntArray>): Array<IntArray> {
        edges.forEach {
            if (it[2] == -1)
                it[2] = 2000000000
        }
        return edges
    }

    private fun dijkstra(conn: Array<MutableMap<Int, Int>>, distTo: IntArray, pq: PriorityQueue<IntArray>) {
        while (pq.isNotEmpty()) {
            val (node, _) = pq.poll()
            for ((next, value) in conn[node]) {
                if (value > 0) {
                    if (distTo[next] - value > distTo[node]) {
                        distTo[next] = distTo[node] + value
                        pq.add(intArrayOf(next, distTo[next]))
                    }
                }
            }
        }
    }
}

fun main() {
//    println(Solution2699().modifiedGraphEdges(5, arrayOf(
//        intArrayOf(4,1,-1), intArrayOf(2,0,-1), intArrayOf(0,3,-1), intArrayOf(4,3,-1)
//    ),0,1,5).map { it.toList() })
//    println(Solution2699().modifiedGraphEdges(3, arrayOf(
//        intArrayOf(0,1,-1), intArrayOf(0,2,5)
//    ),0,2,6).map { it.toList() })
    println(Solution2699().modifiedGraphEdges(4, arrayOf(
        intArrayOf(0,1,-1), intArrayOf(1,2,-1), intArrayOf(3,1,-1), intArrayOf(3,0,2), intArrayOf(0,2,5)
    ),2,3,8).map { it.toList() })
//    println(Solution2699().modifiedGraphEdges(4, arrayOf(
//        intArrayOf(1,0,4), intArrayOf(1,2,3), intArrayOf(2,3,5), intArrayOf(0,3,-1)
//    ),0,2,6).map { it.toList() })
}