package com.ypwang.hard

class Solution2528 {
    fun maxPower(stations: IntArray, r: Int, k: Int): Long {
        var left = 0L
        var right = stations.fold(0L){ a, b -> a + b } + k

        while (left < right) {
            val mid = (left + right + 1) / 2
            // v is the stations after adding
            val v = stations.map { it.toLong() }.toLongArray()
            // s means the power of city i
            var s = (0 until r).map { v[it] }.sum()
            var use = 0L
            for (i in stations.indices) {
                // update s
                if (i + r < stations.size)
                    s += v[i + r]
                if (i - r > 0)
                    s -= v[i - r - 1]
                // missing power stations
                val diff = maxOf(0, mid - s)
                // greedy update to last possible city
                v[minOf(stations.lastIndex, i + r)] += diff
                s += diff
                use += diff
            }
            if (use <= k)
                left = mid
            else
                right = mid - 1
        }
        return left
    }
}

fun main() {
    println(Solution2528().maxPower(intArrayOf(1,2,4,5,0), 1, 2))
}