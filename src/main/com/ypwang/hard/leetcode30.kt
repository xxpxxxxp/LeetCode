package com.ypwang.hard

class Solution30 {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        if (s.isEmpty() || words.isEmpty() || s.length < words.size * words[0].length) return listOf()

        val group = words.groupBy { it }.mapValues { it.value.size }.toList()

        val ws = group.withIndex().map { it.index to it.value.first }
        val reference = group.withIndex().map { it.index to it.value.second }.toMap()

        val idx = IntArray(s.length){-1}

        for ((i, word) in ws) {
            var start = 0
            while (start < s.length) {
                val t = s.indexOf(word, start)
                if (t == -1) break
                idx[t] = i
                start = t + 1
            }
        }

        val len = words[0].length


        val rst = mutableListOf<Int>()
        for (i in 0 until len) {
            val map =  mutableMapOf<Int, Int>()
            for (j in 0 until words.size) {
                val t = idx[i + j * len]
                if (t >= 0) map[t] = map.getOrDefault(t, 0) + 1
            }

            var t = i
            do {
                if (map == reference) rst.add(t)

                val p = idx[t]
                if (p >= 0) {
                    map[p] = map[p]!! - 1
                    if (map[p] == 0) map.remove(p)
                }

                if (t + len * words.size >= s.length) break

                val q = idx[t + len * words.size]
                if (q >= 0) map[q] = map.getOrDefault(q, 0) + 1
                t += len
            } while (true)
        }

        return rst
    }
}

fun main() {
    println(Solution30().findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","good")))
}