package com.ypwang.medium

class DetectSquares {
    private val xa = mutableMapOf<Int, MutableMap<Int, Int>>()

    fun add(point: IntArray) {
        val (x, y) = point
        xa.getOrPut(x) { mutableMapOf() }.let { it[y] = it.getOrDefault(y, 0) + 1 }
    }

    fun count(point: IntArray): Int {
        val (x, y) = point

        if (x !in xa)
            return 0

        return xa[x]!!.map { (sy, c) ->
            if (y == sy)
                0
            else {
                val d = y - sy
                c * listOf(x - d, x + d).map { cx ->
                    xa[cx]?.let { it.getOrDefault(y, 0) * it.getOrDefault(sy, 0) } ?: 0
                }.sum()
            }

        }.sum()
    }
}

fun main() {
    val ds = DetectSquares()
    ds.add(intArrayOf(3, 10))
    ds.add(intArrayOf(11, 2))
    ds.add(intArrayOf(3, 2))
    println(ds.count(intArrayOf(11, 10)))
    println(ds.count(intArrayOf(14, 8)))
    ds.add(intArrayOf(11, 2))
    println(ds.count(intArrayOf(11, 10)))
}