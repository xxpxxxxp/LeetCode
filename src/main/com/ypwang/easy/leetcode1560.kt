package com.ypwang.easy

class Solution1560 {
    fun mostVisited(n: Int, rounds: IntArray): List<Int> {
        val rst = (rounds.first()..rounds.last()).toList()
        if (rst.isNotEmpty())
            return rst

        return (1..rounds.last()).toList() + (rounds.first()..n).toList()
    }
}