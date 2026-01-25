package com.ypwang.medium

import java.util.LinkedList
import java.util.Queue

class Solution3820 {
    fun specialNodes(n: Int, edges: Array<IntArray>, x: Int, y: Int, z: Int): Int {
        val adjacencyList = Array(n) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            adjacencyList[a].add(b)
            adjacencyList[b].add(a)
        }

        val distancesFromX = calculateBFS(n, adjacencyList, x)
        val distancesFromY = calculateBFS(n, adjacencyList, y)
        val distancesFromZ = calculateBFS(n, adjacencyList, z)

        return (0 until n).count {
            val distanceX = distancesFromX[it].toLong()
            val distanceY = distancesFromY[it].toLong()
            val distanceZ = distancesFromZ[it].toLong()
            val maxDistance = maxOf(distanceX, distanceY, distanceZ)

            distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ == 2 * maxDistance * maxDistance
        }
    }

    private fun calculateBFS(n: Int, adjacencyList: Array<MutableList<Int>>, startNode: Int): IntArray {
        val distances = IntArray(n) { -1 }
        val nodeQueue: Queue<Int> = LinkedList()

        distances[startNode] = 0
        nodeQueue.offer(startNode)

        while (nodeQueue.isNotEmpty()) {
            val currentNode: Int = nodeQueue.poll()
            for (neighbor in adjacencyList[currentNode]) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[currentNode] + 1
                    nodeQueue.offer(neighbor)
                }
            }
        }
        return distances
    }
}
