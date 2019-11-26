package com.ypwang.medium

class Leaderboard() {
    private val inner = mutableMapOf<Int, Int>()

    fun addScore(playerId: Int, score: Int) {
        inner[playerId] = inner.getOrDefault(playerId, 0) + score
    }

    fun top(K: Int): Int {
        val values = inner.values.toIntArray()

        // partition array, [i, i+p) >= i+p > (i+p, j)
        var i = 0
        var j = values.lastIndex
        var p = K

        while (i+p <= j) {
            val comp = values[i]
            var start = i
            var end = j
            while (start < end) {
                while (start < end && values[end] < comp) end--
                while (start < end && values[start] >= comp) start++
                if (start < end) {
                    val t = values[start]
                    values[start] = values[end]
                    values[end] = t
                }
            }
            values[i] = values[start]
            values[start] = comp

            if (i+p < start) {
                j = start-1
            } else if (i+p > start+1) {
                p -= (start+1-i)
                i = start+1
            } else break
        }

        return values.take(K).sum()
    }

    fun reset(playerId: Int) {
        inner[playerId] = 0
    }
}

fun main() {
    fun partition(values: IntArray, K: Int) {
        // partition array, [i, i+p) >= i+p > (i+p, j)
        var i = 0
        var j = values.lastIndex
        var p = K

        while (i+p <= j) {
            val comp = values[i]
            var start = i
            var end = j
            while (start < end) {
                while (start < end && values[end] < comp) end--
                while (start < end && values[start] >= comp) start++
                if (start < end) {
                    val t = values[start]
                    values[start] = values[end]
                    values[end] = t
                }
            }
            values[i] = values[start]
            values[start] = comp

            if (i+p < start) {
                j = start-1
            } else if (i+p > start+1) {
                p -= (start+1-i)
                i = start+1
            } else break
        }
    }

    val t = intArrayOf(0,51,39,51,4)
    partition(t, 3)
    println(t.toList())
}