package com.ypwang.easy

class Solution1710 {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int =
        boxTypes.sortedByDescending { it[1] }.fold(truckSize to 0) { (left, total), (num, size) ->
            val take = minOf(left, num)
            (left - take) to (total + take * size)
        }.second
}