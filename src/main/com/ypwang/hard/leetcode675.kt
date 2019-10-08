package com.ypwang.hard

class Solution675 {
    fun cutOffTree(forest: List<List<Int>>): Int {
        val surround = listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)

        val m = forest.size
        val n = forest[0].size

        fun calDist(si: Int, sj: Int, ti: Int, tj: Int): Int {
            var round = setOf(si to sj)
            val walked = mutableSetOf<Pair<Int, Int>>()
            var count = 0

            while (round.isNotEmpty()) {
                if (round.contains(ti to tj)) return count

                walked.addAll(round)
                val next = mutableSetOf<Pair<Int, Int>>()
                for (point in round) {
                    for (s in surround) {
                        val x = point.first + s.first
                        val y = point.second + s.second
                        if (x in 0 until m && y in 0 until n && forest[x][y] > 0 && !walked.contains(x to y)) {
                            next.add(x to y)
                        }
                    }
                }

                round = next
                count++
            }

            return -1
        }

        val targets = mutableListOf<Pair<Int, Pair<Int, Int>>>()

        for ((i, l) in forest.withIndex()) {
            for ((j, v) in l.withIndex()) {
                if (v > 1) {
                    targets.add(v to (i to j))
                }
            }
        }

        return targets.sortedBy { it.first }.map { it.second }.fold(Triple(0, 0, 0)){ acc, cur ->
            if (acc.third == -1) acc
            else {
                val dist = calDist(acc.first, acc.second, cur.first, cur.second)
                if (dist == -1) Triple(0, 0, -1)
                else Triple(cur.first, cur.second, acc.third + dist)
            }
        }.third
    }
}

fun main() {
    println(Solution675().cutOffTree(listOf(listOf(1,2,3), listOf(0,0,4), listOf(7,6,5))))
    println(Solution675().cutOffTree(listOf(listOf(1,2,3), listOf(0,0,0), listOf(7,6,5))))
    println(Solution675().cutOffTree(listOf(listOf(2,3,4), listOf(0,0,5), listOf(8,7,6))))
}