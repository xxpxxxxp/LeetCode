package com.ypwang.medium

class Solution1996 {
    fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
        properties.sortWith(compareByDescending<IntArray> { it[0] }.thenBy { it[1] })
        var max = 0
        var rst = 0
        for ((_, d) in properties) {
            if (d < max)
                rst++

            max = maxOf(max, d)
        }

        return rst
    }
}