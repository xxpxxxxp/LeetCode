//package com.ypwang.hard
//
//class Solution850 {
//    fun rectangleArea(rectangles: Array<IntArray>): Int {
//        val map = mutableMapOf<Int, IntArray>()
//
//        for ((x1, y1, x2, y2) in rectangles) {
//            if (x1 !in map) map[x1] = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE)
//            if (x2 !in map) map[x2] = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE)
//            map[x1] = intArrayOf(minOf(y1, map[x1]!![0]), maxOf(y2, map[x1]!![1]))
//            map[x2] = intArrayOf(minOf(y1, map[x2]!![0]), maxOf(y2, map[x2]!![1]))
//        }
//
//        var rst = 0
//        var preX: Int? = null
//        var preY = intArrayOf()
//        for ((x, y) in map.toList().sortedBy { it.first }) {
//            if (preX != null) {
//                rst = ((rst + (x - preX).toLong() * (minOf(preY[1], y[1]) - maxOf(preY[0], y[0]))) % 1000000007).toInt()
//            }
//
//            preX = x
//            preY = y
//        }
//
//        return rst
//    }
//}
//
//fun main() {
//    println(Solution850().rectangleArea(arrayOf(
//            intArrayOf(0,0,1,1),
//            intArrayOf(2,2,3,3)
//    )))
//
//    println(Solution850().rectangleArea(arrayOf(
//            intArrayOf(0,0,2,2),
//            intArrayOf(1,0,2,3),
//            intArrayOf(1,0,3,1)
//    )))
//
//    println(Solution850().rectangleArea(arrayOf(
//            intArrayOf(0,0,1000000000,1000000000)
//    )))
//}