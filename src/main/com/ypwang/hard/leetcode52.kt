package com.ypwang.hard

import kotlin.math.absoluteValue

class Solution52 {
    fun totalNQueens(n: Int): Int {
        val take = mutableSetOf<Int>()
        var count = 0

        fun helper(dep: Int, ps: MutableList<Pair<Int, Int>>) {
            if (dep == n) {
                count++
            }
            for (i in 0 until n) {
                if (i !in take && ps.all { (it.first - dep).absoluteValue != (it.second - i).absoluteValue }) {
                    // take i
                    take.add(i)
                    ps.add(Pair(dep, i))
                    helper(dep + 1, ps)
                    take.remove(i)
                    ps.removeAt(ps.lastIndex)
                }
            }
        }

        val t = mutableListOf<Pair<Int, Int>>()
        helper(0, t)
        return count
    }
}