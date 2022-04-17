package com.ypwang.medium

class Solution2240 {
    fun waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long {
        val (min, max) = listOf(cost1, cost2).sorted()
        return (0 .. (total/max)).map { 1L + (total - max * it) / min }.sum()
    }
}