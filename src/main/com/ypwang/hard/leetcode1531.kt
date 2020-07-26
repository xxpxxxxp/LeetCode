package com.ypwang.hard

class Solution1531 {
    data class State(
            val idx: Int,
            val char: Char,
            val count: Int,
            val leftK: Int
    )

    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val cache = mutableMapOf<State, Int>()
        fun counter(state: State): Int {
            if (state.leftK < 0) return Int.MAX_VALUE
            if (state.idx == s.length) return 0

            if (state !in cache) {
                cache[state] =
                if (s[state.idx] == state.char) {
                    val incr = if (state.count in setOf(1, 9, 99)) 1 else 0
                    incr + counter(
                            state.run {
                                State(idx+1, char, count+1, leftK)
                            }
                    )
                } else {
                    state.run {
                        minOf(1 + counter(State(idx+1, s[idx], 1, leftK)),
                                counter(State(idx+1, char, count, leftK-1))
                        )
                    }

                }
            }

            return cache[state]!!
        }

        return counter(State(0, '-', 0, k))
    }
}