package com.ypwang.medium

class Solution4001 {
    fun aggregateTimeSeries(series1: Array<IntArray>, series2: Array<IntArray>): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        var i = 0
        var j = 0

        while (i < series1.size && j < series2.size) {
            if (series1[i][0] == series2[j][0]) {
                ans.add(listOf(series1[i][0], series2[j][1] + series1[i][1]))
                i++
                j++
            } else if (series1[i][0] < series2[j][0]) {
                ans.add(listOf(series1[i][0], series1[i][1] + series2[j][1]))
                i++
            } else {
                ans.add(listOf(series2[j][0], series2[j][1] + series1[i][1]))
                j++
            }
        }
        while (i < series1.size) {
            ans.add(listOf(series1[i][0], series1[i][1]))
            i++
        }
        while (j < series2.size) {
            ans.add(listOf(series2[j][0], series2[j][1]))
            j++
        }
        return ans
    }
}
