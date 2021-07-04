package com.ypwang.medium

class Solution1921 {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int =
        dist.zip(speed).map { (d, s) -> (d + s - 1) / s }.sorted().withIndex().firstOrNull { (idx, v) -> idx >= v }?.index ?: dist.size
}

fun main() {
    println(Solution1921().eliminateMaximum(intArrayOf(1,3,4), intArrayOf(1,1,1)))
    println(Solution1921().eliminateMaximum(intArrayOf(1,1,2,3), intArrayOf(1,1,1,1)))
    println(Solution1921().eliminateMaximum(intArrayOf(3,2,4), intArrayOf(5,3,2)))
}