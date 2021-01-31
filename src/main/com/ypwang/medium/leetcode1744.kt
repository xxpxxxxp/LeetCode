package com.ypwang.medium

class Solution1744 {
    fun canEat(candiesCount: IntArray, queries: Array<IntArray>): BooleanArray {
        val preSum = LongArray(candiesCount.size + 1)
        for (i in candiesCount.indices) {
            preSum[i+1] = preSum[i] + candiesCount[i]
        }

        return queries.map { (i, d, c) ->
            d in (preSum[i] / c) until preSum[i+1]
        }.toBooleanArray()
    }
}

fun main() {
    println(Solution1744().canEat(intArrayOf(46,5,47,48,43,34,15,26,11,25,41,47,15,25,16,50,32,42,32,21,36,34,50,45,46,15,46,38,50,12,3,26,26,16,23,1,4,48,47,32,47,16,33,23,38,2,19,50,6,19,29,3,27,12,6,22,33,28,7,10,12,8,13,24,21,38,43,26,35,18,34,3,14,48,50,34,38,4,50,26,5,35,11,2,35,9,11,31,36,20,21,37,18,34,34,10,21,8,5),
        arrayOf(intArrayOf(85,54,42))).toList())
}