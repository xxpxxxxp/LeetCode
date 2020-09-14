package com.ypwang.medium

class Solution1583 {
    fun unhappyFriends(n: Int, preferences: Array<IntArray>, pairs: Array<IntArray>): Int {
        val cache = Array(n) { BooleanArray(n) }

        fun set(i: Int, j: Int) {
            val friends = preferences[i]
            for (z in friends) {
                if (j == z) break
                cache[i][z] = true
            }
        }

        for ((i, j) in pairs) {
            set(i, j)
            set(j, i)
        }

        val unhappy = mutableSetOf<Int>()
        for (i in 0 until n) {
            for (j in i+1 until n) {
                if (cache[i][j] && cache[j][i]) {
                    unhappy.add(i)
                    unhappy.add(j)
                }
            }
        }

        return unhappy.size
    }
}