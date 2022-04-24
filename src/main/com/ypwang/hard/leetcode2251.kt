package com.ypwang.hard

import java.util.*

class Solution2251 {
    fun fullBloomFlowers(flowers: Array<IntArray>, persons: IntArray): IntArray {
        val treeMap = TreeMap<Int, Int>()
        for ((s, e) in flowers) {
            treeMap[s] = treeMap.getOrDefault(s, 0) + 1
            // use end + 1 instead of end
            treeMap[e + 1] = treeMap.getOrDefault(e + 1, 0) - 1
        }
        val sum = TreeMap<Int, Int>()
        var prev = 0
        for ((key, value) in treeMap) {
            prev += value
            sum[key] = prev
        }
        return persons.map { sum.floorEntry(it)?.value?:0 }.toIntArray()
    }
}

fun main() {
    println(Solution2251().fullBloomFlowers(
        arrayOf(intArrayOf(36,39),intArrayOf(29,49),intArrayOf(32,35),intArrayOf(14,43),intArrayOf(42,49),intArrayOf(48,48),intArrayOf(32,46),intArrayOf(6,41),intArrayOf(14,19)), intArrayOf(14,4)
    ).toList())
    println(Solution2251().fullBloomFlowers(
        arrayOf(intArrayOf(1,6), intArrayOf(3,7), intArrayOf(9,12), intArrayOf(4,13)), intArrayOf(2,3,7,11)
    ).toList())
}