package com.ypwang.hard

class Solution1521 {
    fun closestToTarget(arr: IntArray, target: Int): Int =
            arr.fold(setOf<Int>() to Int.MAX_VALUE){ (set, diff), i ->
                val n = (set.map { it and i } + listOf(i)).toSet()
                n to minOf(diff, n.map { Math.abs(it - target) }.min()!!)
            }.second
}