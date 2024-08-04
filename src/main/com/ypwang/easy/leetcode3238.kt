package com.ypwang.easy

class Solution3238 {
    fun winningPlayerCount(n: Int, pick: Array<IntArray>): Int {
        val t = Array(n) { mutableListOf<Int>() }
        for ((i, v) in pick)
            t[i].add(v)

        return t.withIndex().count {
            val c = if (it.value.isEmpty())
                0
            else
                it.value.groupBy { i->i }.map { i->i.value.size }.max()!!
            c > it.index
        }
    }
}
