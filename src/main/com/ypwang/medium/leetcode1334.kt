package com.ypwang.medium

class Solution1334 {
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val dist = Array(n){ IntArray(n) { 100000 } }
        for ((i, j, v) in edges) {
            dist[i][j] = v
            dist[j][i] = v
        }

        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (i != j && dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }

        return dist.withIndex().fold(-1 to 100000){ cur, it ->
            val count = it.value.count{ v -> v <= distanceThreshold }
            if (count <= cur.second) it.index to count else cur
        }.first
    }
}