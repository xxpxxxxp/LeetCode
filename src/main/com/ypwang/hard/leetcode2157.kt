package com.ypwang.hard

class Solution2157 {
    class Word(val len: Int, val mask: Int)

    fun groupStrings(words: Array<String>): IntArray {
        val ws = words.map { Word(it.length, it.fold(0){ cur, c -> cur or (1 shl (c - 'a')) }) }.toTypedArray()

        val dsu = IntArray(words.size) { it }

        fun root(i: Int): Int {
            if (i != dsu[i])
                dsu[i] = root(dsu[i])

            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            dsu[root(i)] = root(j)
        }

        for ((i, w1) in ws.withIndex()) {
            for (j in i+1 until ws.size) {
                val w2 = ws[j]
                if (Math.abs(w1.len - w2.len) < 2 && Integer.bitCount(w1.mask xor w2.mask) <= 2)
                    union(i, j)
            }
        }

        return dsu.indices
            .map { root(it) }
            .groupBy { it }
            .mapValues { it.value.size }
            .let { intArrayOf(it.size, it.values.maxOrNull()!!) }
    }
}

fun main() {
    println(Solution2157().groupStrings(arrayOf("a","b","ab","cde")).toList())
    println(Solution2157().groupStrings(arrayOf("a","ab","abc")).toList())
}