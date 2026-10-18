package com.ypwang.hard

class Solution4086 {
    fun minSelection(availableIntervals: Array<IntArray>, targetIntervals: Array<IntArray>): Int {
        availableIntervals.sortBy { it[0] }
        targetIntervals.sortBy { it[0] }

        val tar = mutableListOf<IntArray>()
        for (t in targetIntervals) {
            if (tar.isEmpty() || t[0] > tar.last()[1]) {
                tar.add(intArrayOf(t[0], t[1]))
            } else {
                val end = tar.last()
                end[1] = maxOf(end[1], t[1])
            }
        }

        // use line swip kind of someting
        var cnt = 0
        var i = 0
        var covered = -1
        val n = availableIntervals.size
        for ((l, r) in tar) {
            // extend
            while (covered < r) {
                val start = maxOf(covered, l) // is l covered?
                var end = covered
                while (i < n && availableIntervals[i][0] <= start) {
                    end = maxOf(end, availableIntervals[i][1])
                    i++
                }

                if (end <= covered || end < l)
                    return -1

                covered = end
                cnt++
            }
        }
        return cnt
    }
}
