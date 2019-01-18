package com.ypwang.medium

import kotlin.math.absoluteValue

class Solution939 {
    fun hash(point: Pair<Int, Int>): Int = point.first * 65657 + point.second

    fun minAreaRect(points: Array<IntArray>): Int {
        val ps = points.map{ Pair(it[0], it[1]) }.toTypedArray()
        val hashs = ps.map{ hash(it) }.toSet()

        var area = Int.MAX_VALUE
        for (i in 0 until ps.size) {
            val a = ps[i]
            for (j in i+1 until ps.size) {
                val b = ps[j]

                if (a.first != b.first && a.second != b.second
                    && hash(Pair(a.first, b.second)) in hashs
                    && hash(Pair(b.first, a.second)) in hashs
                ) {
                    val cur = ((a.first - b.first) * (a.second - b.second)).absoluteValue
                    if (cur < area) area = cur
                }
            }
        }

        return if (area == Int.MAX_VALUE) 0 else area
    }
}

fun main(args: Array<String>) {
    println(Solution939().minAreaRect(arrayOf(
            intArrayOf(1,1), intArrayOf(1,3), intArrayOf(3,1), intArrayOf(3,3), intArrayOf(4,1), intArrayOf(4,3)
    )))
}