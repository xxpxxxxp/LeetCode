package com.ypwang.medium

class Solution835 {
    data class Point(val x: Int, val y: Int)
    fun largestOverlap(A: Array<IntArray>, B: Array<IntArray>): Int {
        val ap = A.withIndex().flatMap { (index, array) -> array.withIndex().filter { it.value == 1 }.map { Point(index, it.index) } }
        val bp = B.withIndex().flatMap { (index, array) -> array.withIndex().filter { it.value == 1 }.map { Point(index, it.index) } }.toSet()

        val size = A.size
        return ap.flatMap { a -> bp.map {
            b -> (a.x - b.x + size) * 113 + (a.y - b.y + size)
        } }.groupBy { it }.mapValues { it.value.size }.maxBy { it.value }?.value ?: 0
    }
}

fun main(args: Array<String>) {
    println(Solution835().largestOverlap(
            arrayOf(intArrayOf(1,1), intArrayOf(1,1)),
            arrayOf(intArrayOf(0,1), intArrayOf(1,0))
    ))
}