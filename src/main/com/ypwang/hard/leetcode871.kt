package com.ypwang.hard

class Solution871 {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        var fuelMap = mutableMapOf(0 to startFuel)
        for (station in stations) {
            if (station[0] >= target) return fuelMap.filter { it.value >= target }.minByOrNull { it.key }?.key ?: -1

            val next = fuelMap.filter { it.value >= station[0] }

            fuelMap = next.toMap().toMutableMap()
            next.map { it.key + 1 to it.value + station[1] }.forEach {
                fuelMap[it.first] = maxOf(fuelMap.getOrDefault(it.first, 0), it.second)
            }
        }

        return fuelMap.filter { it.value >= target }.minByOrNull { it.key }?.key ?: -1
    }
}