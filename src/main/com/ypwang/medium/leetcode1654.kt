package com.ypwang.medium

class Solution1654 {
    fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
        val max = x + a + b
        val seen = mutableSetOf<Int>()
        val banned = forbidden.toSet()

        var count = 0
        var round = setOf(0 to 0)

        while (round.isNotEmpty()) {
            seen.addAll(round.map { it.first })
            val next = mutableSetOf<Pair<Int, Int>>()

            for ((pos, dir) in round) {
                if (pos == x)
                    return count

                // forward
                val fpos = pos + a
                if (fpos in 0..max && fpos !in banned && fpos !in seen) {
                    next.add(fpos to 0)
                }

                if (dir == 0) {
                    val bpos = pos - b
                    if (bpos in 0..max && bpos !in banned && bpos !in seen) {
                        next.add(bpos to 1)
                    }
                }
            }

            count++
            round = next
        }

        return -1
    }
}