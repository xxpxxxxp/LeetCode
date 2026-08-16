package com.ypwang.easy

class Solution4024 {
    fun nearestDrone(drones: Array<IntArray>, target: IntArray): Int =
        drones.withIndex().map { (i, value) ->
            val (x, y, r) = value
            val dis = Math.abs(x - target[0]) + Math.abs(y - target[1])
            Triple(i, dis, r)
        }
            .filter { it.second <= it.third }
            .minWithOrNull(compareBy<Triple<Int, Int, Int>> { it.second }.thenBy { it.first })
            ?.first ?: -1
    }
