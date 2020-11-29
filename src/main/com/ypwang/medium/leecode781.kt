package com.ypwang.medium

class Solution781 {
    fun numRabbits(answers: IntArray): Int {
        val m = mutableListOf<Pair<Int, Int>>() // total, unfilled

        for (rabbit in answers) {
            val total = rabbit + 1
            val index = m.indexOfFirst { it.first == total && it.second > 0 }
            if (index == -1) {
                m.add(Pair(total, rabbit))
            } else {
                m[index] = Pair(m[index].first, m[index].second - 1)
            }
        }

        return m.sumBy { it.first }
    }
}

fun main() {
    println(Solution781().numRabbits(intArrayOf(1,1,2)))
    println(Solution781().numRabbits(intArrayOf(10,10,10)))
    println(Solution781().numRabbits(intArrayOf()))
}