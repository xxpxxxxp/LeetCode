package com.ypwang.medium

class Solution1049 {
    fun lastStoneWeightII(stones: IntArray): Int = stones.fold(setOf(0)) { cur, stone -> (cur.map { it + stone } + cur.map { Math.abs(it - stone) }).toSet() }.min()!!
}