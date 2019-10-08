package com.ypwang.easy

class Solution1184 {
    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
        var sum = 0
        var partial = 0
        for (i in distance.indices) {
            sum += distance[i]
            if (i in minOf(start, destination) until maxOf(start, destination)) {
                partial += distance[i]
            }
        }

        return minOf(partial, sum - partial)
    }
}