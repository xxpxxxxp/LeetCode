package com.ypwang.medium

class Solution953 {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        if (words.size < 2) {
            return true
        }

        val dict = order.toCharArray().toList().zip(List(26){it}).map {
            Pair(it.first, it.second)
        }.toMap()

        for (i in 0 until words.lastIndex) {
            val first = words[i]
            val second = words[i+1]
            for ((index, j) in first.withIndex()) {
                if (index > second.lastIndex) {
                    return false
                }
                if (dict[j]!! > dict[second[index]]!!) {
                    return false
                }
                if (dict[j]!! < dict[second[index]]!!) {
                    break
                }
            }
        }

        return true
    }
}

fun main() {
    println(Solution953().isAlienSorted(arrayOf("word","world","row"), "worldabcefghijkmnpqstuvxyz"))
}