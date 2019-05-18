package com.ypwang.hard

class Solution982 {
    fun countTriplets(A: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for (a in A) {
            for (b in A) {
                val cur = a and b
                map[cur] = map.getOrDefault(cur, 0) + 1
            }
        }

        var count = 0
        for ((k, v) in map) {
            for (a in A) {
                if (a and k == 0)
                    count += v
            }
        }

        return count
    }
}