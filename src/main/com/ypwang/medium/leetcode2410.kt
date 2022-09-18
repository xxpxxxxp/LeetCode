package com.ypwang.medium

class Solution2410 {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        trainers.sort()
        players.sort()
        var i = 0
        for (t in trainers) {
            if (t >= players[i])
                i++
            if (i == players.size)
                break
        }

        return i
    }
}