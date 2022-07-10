package com.ypwang.medium

class Solution2332 {
    fun latestTimeCatchTheBus(buses: IntArray, passengers: IntArray, capacity: Int): Int {
        buses.sort()
        passengers.sort()

        val set = mutableSetOf<Int>()
        var ans = 0
        var j = 0
        for (v in buses) {
            var c = 0
            while (j < passengers.size && c < capacity && passengers[j] <= v) {
                if (passengers[j] - 1 !in set)
                    ans = passengers[j] - 1

                set.add(passengers[j])
                j++
                c++
            }
            if (c < capacity && v !in set)
                ans = v
        }
        return ans
    }
}