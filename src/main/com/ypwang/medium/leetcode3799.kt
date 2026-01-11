package com.ypwang.medium

class Solution3799 {
    fun wordSquares(words: Array<String>): List<List<String>> {
        words.sort()
        val result = mutableListOf<List<String>>()
        val n = words.size

        for (a in 0 until n) {
            for (b in 0 until n) {
                if (a != b && words[a][0] == words[b][0]) {
                    for (c in 0 until n) {
                        if (c != a && c != b && words[a][3] == words[c][0]) {
                            for (d in 0 until n) {
                                if (d != a && d != b && d != c && words[d][0] == words[b][3] && words[d][3] == words[c][3])
                                    result.add(listOf(words[a], words[b], words[c], words[d]))
                            }
                        }
                    }
                }
            }
        }

        return result
    }
}
