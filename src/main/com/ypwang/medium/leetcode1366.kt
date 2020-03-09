package com.ypwang.medium

class Solution1366 {
    fun rankTeams(votes: Array<String>): String {
        val pos = votes[0].map { c -> c to IntArray(votes[0].length) }.toMap()
        for (vote in votes) {
            for ((i, c) in vote.withIndex()) {
                pos[c]!![i]++
            }
        }
        return pos.toList().sortedWith(Comparator { (c1, i1), (c2, i2) ->
            for ((a, b) in i1.zip(i2)) {
                if (a != b) return@Comparator b.compareTo(a)
            }
            c1.compareTo(c2)
        }).joinToString("") { it.first.toString() }
    }
}

fun main() {
    println(Solution1366().rankTeams(arrayOf("WXYZ","XYZW")))
}