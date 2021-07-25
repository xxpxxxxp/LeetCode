package com.ypwang.medium

class Solution1943 {
    fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
        val points = segments.flatMap { listOf(it[0], it[1]) }.toSet().sorted().toIntArray()
        val count = IntArray(points.size)
        val reverseMap = points.withIndex().associate { it.value to it.index }

        for ((s, e, v) in segments) {
            count[reverseMap[s]!!] += v
            count[reverseMap[e]!!] -= v
        }

        val rst = mutableListOf<List<Long>>()
        var sum = 0L
        for (i in 0 until points.lastIndex) {
            sum += count[i]
            if (sum != 0L)
                rst.add(listOf(points[i].toLong(), points[i+1].toLong(), sum))
        }

        return rst
    }
}

fun main() {
    println(Solution1943().splitPainting(arrayOf(
        intArrayOf(1,4,5),intArrayOf(4,7,7),intArrayOf(1,7,9)
    )))
    println(Solution1943().splitPainting(arrayOf(
        intArrayOf(1,7,9),intArrayOf(6,8,15),intArrayOf(8,10,7)
    )))
    println(Solution1943().splitPainting(arrayOf(
        intArrayOf(1,4,5),intArrayOf(1,4,7),intArrayOf(4,7,1),intArrayOf(4,7,11)
    )))
}