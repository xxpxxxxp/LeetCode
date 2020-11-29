package com.ypwang.easy

import kotlin.math.*

class Solution812 {
    fun heron(a: IntArray, b: IntArray, c: IntArray): Double {
        return (0.5*abs((b[0]-a[0])*(c[1]-a[1]) - (b[1]-a[1])*(c[0]-a[0])))
    }

    fun largestTriangleArea(points: Array<IntArray>): Double {
        val l = mutableSetOf<Set<Int>>()

        for (i in 0 until points.size) {
            for (j in 1 until points.size) {
                for (k in 2 until points.size) {
                    l.add(setOf(i, j ,k))
                }
            }
        }

        return l.asSequence().filter{ it.size == 3 }.map {
            val (i, j, k) = it.toList()
            heron(points[i], points[j], points[k])
        }.filter { !it.isNaN() }.max()!!
    }
}

fun main() {
    println(Solution812().largestTriangleArea(arrayOf(intArrayOf(35,-23),intArrayOf(-12,-48),intArrayOf(-34,-40),intArrayOf(21,-25),intArrayOf(-35,-44),intArrayOf(24,1),intArrayOf(16,-9),intArrayOf(41,4),intArrayOf(-36,-49),intArrayOf(42,-49),intArrayOf(-37,-20),intArrayOf(-35,11),intArrayOf(-2,-36),intArrayOf(18,21),intArrayOf(18,8),intArrayOf(-24,14),intArrayOf(-23,-11),intArrayOf(-8,44),intArrayOf(-19,-3),intArrayOf(0,-10),intArrayOf(-21,-4),intArrayOf(23,18),intArrayOf(20,11),intArrayOf(-42,24),intArrayOf(6,-19))))
}