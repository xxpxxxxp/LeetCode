package com.ypwang.medium

class Solution3679 {
    fun minArrivalsToDiscard(arrivals: IntArray, w: Int, m: Int): Int {
        val n = arrivals.size
        if (n == 0)
            return 0

        val map = mutableMapOf<Int, Int>()
        val kept = IntArray(n)
        var dis = 0

        for (i in 0 until n) {
            val idx = i - w
            if (idx >= 0 && kept[idx] == 1)
                map[arrivals[idx]] = map.get(arrivals[idx])!! - 1

            val t = arrivals[i]
            if (map.getOrDefault(t, 0) < m) {
                kept[i] = 1
                map[t] = map.getOrDefault(t, 0) + 1
            } else {
                dis++
            }
        }
        return dis
    }
}
