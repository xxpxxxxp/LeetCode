package com.ypwang.medium

class Solution2225 {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val players = IntArray(100001)
        for ((w, l) in matches) {
            if (players[w] == 0)
                players[w] = players[w] or 0x10000
            players[l] = (players[l] and 0xFFFF) + 1
        }

        return listOf(
            (1..100000).filter { players[it] > 0 && players[it] and 0xFFFF == 0 },
            (1..100000).filter { players[it] and 0xFFFF == 1 }
        )
    }
}