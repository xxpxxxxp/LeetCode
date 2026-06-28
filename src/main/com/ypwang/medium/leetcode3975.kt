package com.ypwang.medium

class Solution3975 {
    fun filterOccupiedIntervals(occupiedIntervals: Array<IntArray>, freeStart: Int, freeEnd: Int): List<List<Int>> {
        occupiedIntervals.sortWith(compareBy { it[0] })
        val temp = mutableListOf<IntArray>()
        for (brr in occupiedIntervals) {
            if (temp.isEmpty() || temp.last()[1] + 1 < brr[0])
                temp.add(intArrayOf(brr[0], brr[1]))
            else
                temp[temp.size - 1][1] = maxOf(temp[temp.size - 1][1], brr[1])
        }
        val res = mutableListOf<List<Int>>()
        for ((s, e) in temp) {
            if (e < freeStart || s > freeEnd)
                res.add(listOf(s, e))
            else {
                if (s < freeStart)
                    res.add(listOf(s, freeStart - 1))
                if (e > freeEnd)
                    res.add(listOf(freeEnd + 1, e))
            }
        }

        return res
    }
}
