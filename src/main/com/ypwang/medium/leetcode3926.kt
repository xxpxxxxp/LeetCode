package com.ypwang.medium

class Solution3926 {
    fun countWordOccurrences(chunks: Array<String>, queries: Array<String>): IntArray {
        val total = chunks.joinToString("")
        val counts = getValidWords(total).groupBy { it }.mapValues { it.value.size }

        return queries.map { counts.getOrDefault(it, 0) }.toIntArray()
    }

    fun getValidWords(s: String): List<String> {
        val words = mutableListOf<String>()
        val currentWord = StringBuilder()
        val n = s.length

        for (i in 0 until n) {
            val c = s[i]

            if (c.isLetter()) {
                currentWord.append(c)
            } else if (c == '-' && isSurrounded(s, i)) {
                currentWord.append(c)
            } else {
                if (currentWord.isNotEmpty()) {
                    words.add(currentWord.toString())
                    currentWord.setLength(0)
                }
            }
        }

        if (currentWord.isNotEmpty()) {
            words.add(currentWord.toString())
        }

        return words
    }

    private fun isSurrounded(s: String, i: Int): Boolean =
        i > 0 && i < s.length - 1 && s[i - 1].isLetter() && s[i + 1].isLetter()
}
