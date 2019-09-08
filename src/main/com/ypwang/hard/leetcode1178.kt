package com.ypwang.hard

class Solution1178 {
    fun findNumOfValidWords(words: Array<String>, puzzles: Array<String>): List<Int> {
        val map = mutableMapOf<Int, Int>()
        for (word in words) {
            var t = 0
            for (c in word) {
                t = t or (1 shl (c - 'a'))
            }

            map[t] = map.getOrDefault(t, 0) + 1
        }

        val rst = IntArray(puzzles.size)
        for ((i, puzzle) in puzzles.withIndex()) {
            var t = 0
            for (c in puzzle) {
                t = t or (1 shl (c - 'a'))
            }

            var count = 0
            var sub = t
            val first = 1 shl (puzzle[0] - 'a')

            while (true) {
                if (sub and first != 0 && map.containsKey(sub)) {
                    count += map[sub]!!
                }

                if (sub == 0) break
                sub = (sub - 1) and t
            }

            rst[i] = count
        }

        return rst.toList()
    }
}

fun main() {
    println(Solution1178().findNumOfValidWords(arrayOf("aaaa","asas","able","ability","actt","actor","access"),
            arrayOf("aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz")))
}