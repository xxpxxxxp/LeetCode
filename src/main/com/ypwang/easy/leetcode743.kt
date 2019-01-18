package com.ypwang.easy

class Solution743 {
    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val connections = times.groupBy { it[0] }.mapValues { it.value.map { t -> Pair(t[1], t[2]) }.toMap() }
        val left = List(N){ it+1 }.map { Pair(it, Int.MAX_VALUE) }.toMap().toMutableMap()

        for ((n, l) in connections[K] ?: mapOf()) {
            left[n] = l
        }

        left.remove(K)

        if (left.isEmpty())
            return 0

        while (true) {
            val c = left.minBy { it.value }!!
            if (c.value == Int.MAX_VALUE)
                return -1

            left.remove(c.key)
            if (left.isEmpty()) {
                return c.value
            }

            val curTime = c.value
            for ((n, l) in connections[c.key] ?: mapOf()) {
                if (n in left && left[n]!! > curTime + l) {
                    left[n] = curTime + l
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    println(Solution743().networkDelayTime(
        arrayOf(intArrayOf(1,2,1)),
            2, 2)
    )
}