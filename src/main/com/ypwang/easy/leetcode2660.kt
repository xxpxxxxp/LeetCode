package com.ypwang.easy

class Solution2660 {
    fun isWinner(player1: IntArray, player2: IntArray): Int {
        var s1 = player1.sum()
        var s2 = player2.sum()
        for ((i, v) in player1.withIndex()) {
            if (i - 1 >= 0 && player1[i-1] == 10)
                s1 += v
            else if (i - 2 >= 0 && player1[i-2] == 10)
                s1 += v
        }
        for ((i, v) in player2.withIndex()) {
            if (i - 1 >= 0 && player2[i-1] == 10)
                s2 += v
            else if (i - 2 >= 0 && player2[i-2] == 10)
                s2 += v
        }
        return if (s1 > s2) 1
        else if (s1 < s2) 2
        else 0
    }
}
