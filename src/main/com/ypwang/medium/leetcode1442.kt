package com.ypwang.medium

class Solution1442 {
    fun countTriplets(arr: IntArray): Int {
        val map = mutableMapOf(0 to mutableListOf(-1))

        var xor = 0
        var rst = 0
        for ((i, v) in arr.withIndex()) {
            xor = xor.xor(v)
            map[xor]?.sumBy { i - it - 1 }?.let { rst += it }
            map.getOrPut(xor, { mutableListOf() }).add(i)
        }

        return rst
    }
}

fun main() {
    println(Solution1442().countTriplets(intArrayOf(2,3,1,6,7)))
    println(Solution1442().countTriplets(intArrayOf(1,1,1,1,1)))
    println(Solution1442().countTriplets(intArrayOf(2,3)))
    println(Solution1442().countTriplets(intArrayOf(1,3,5,7,9)))
    println(Solution1442().countTriplets(intArrayOf(7,11,12,9,5,2,7,17,22)))
}