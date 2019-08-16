package com.ypwang.medium

class Solution1052 {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, X: Int): Int {
        val overall = customers.zip(grumpy).toTypedArray()

        var sum = overall.filter { it.second == 0 }.sumBy { it.first }
        // init window
        for (i in 0 until X) {
            if (overall[i].second == 1)
                sum += overall[i].first
        }

        var max = sum

        for (j in X until overall.size) {
            if (overall[j-X].second == 1) sum -= overall[j-X].first
            if (overall[j].second == 1) sum += overall[j].first
            if (sum > max) max = sum
        }

        return max
    }
}