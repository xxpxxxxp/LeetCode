package com.ypwang.medium

class RideSharingSystem() {
    var drivers = ArrayDeque<Int>()
    var riders= ArrayDeque<Int>()
    var waiting = mutableSetOf<Int>()
    var cancelled = mutableSetOf<Int>()

    fun addRider(riderId: Int) {
        riders.addLast(riderId)
        waiting.add(riderId)
    }

    fun addDriver(driverId: Int) {
        drivers.addLast(driverId)
    }

    fun matchDriverWithRider(): IntArray {
        while (riders.isNotEmpty() && riders.first() in cancelled) {
            val rid = riders.removeFirst()
            cancelled.remove(rid)
            waiting.remove(rid)
        }

        if (riders.isNotEmpty() && drivers.isNotEmpty()) {
            val did = drivers.removeFirst()
            val rid = riders.removeFirst()
            waiting.remove(rid)
            return intArrayOf(did, rid)
        }

        return intArrayOf(-1, -1)
    }

    fun cancelRider(riderId: Int) {
        if (riderId in waiting)
            cancelled.add(riderId)
    }
}
