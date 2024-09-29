package com.ypwang.medium

class Solution3302 {
    fun validSequence(word1: String, word2: String): IntArray {
        val length1 = word1.length
        val length2 = word2.length
        val indices = IntArray(length1)
        var j = length2 - 1

        for (i in length1 - 1 downTo 0) {
            indices[i] = if (j >= 0 && word1[i] == word2[j]) {
                j--
                if (i == length1 - 1) 1 else indices[i + 1] + 1
            } else {
                if (i == length1 - 1) 0 else indices[i + 1]
            }
        }

        j = 0
        val result = mutableListOf<Int>()
        var finalIndex = -1

        for (i in 0 until length1) {
            if (word1[i] == word2[j]) {
                result.add(i)
                j++
                if (j == length2)
                    break
            } else {
                if ((if (i == length1 - 1) 0 else indices[i + 1]) >= length2 - j - 1) {
                    result.add(i)
                    j++
                    finalIndex = i + 1
                    break
                }
            }
        }

        if (result.size == length2)
            return result.toIntArray()

        if (finalIndex == -1)
            return intArrayOf()

        for (i in finalIndex until length1) {
            if (word1[i] == word2[j]) {
                result.add(i)
                j++
            }
            if (j == length2) {
                break
            }
        }

        return if (result.size == length2) result.toIntArray() else intArrayOf()
    }
}
