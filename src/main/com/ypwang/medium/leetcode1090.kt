package com.ypwang.medium

class Solution1090 {
    fun largestValsFromLabels(values: IntArray, labels: IntArray, num_wanted: Int, use_limit: Int): Int {
        val count = mutableMapOf<Int, Int>()

        var sum = 0
        var c = 0
        for ((v, l) in values.zip(labels).sortedByDescending { it.first }) {
            if (c == num_wanted) break

            if (count.getOrDefault(l, 0) < use_limit) {
                count[l] = count.getOrDefault(l, 0) + 1
                c++
                sum += v
            }
        }

        return sum
    }
}