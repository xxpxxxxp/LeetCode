package com.ypwang.medium

class Solution3403 {
    fun answerString(word: String, numFriends: Int): String {
        if (numFriends == 1)
            return word

        val maxLen = word.length - numFriends + 1
        val maxChar = word.max()

        var idx = word.indices.filter { word[it] == maxChar }
        var sb = StringBuilder()

        var len = 0
        while (idx.isNotEmpty() && len < maxLen) {
            sb.append(word[idx.first()])
            var next = idx.map { it+1 }.filter { it < word.length }
            if (next.isEmpty())
                break

            var mc = next.maxOf { word[it] }
            idx = next.filter { word[it] == mc }
            len++
        }

        return sb.toString()
    }
}

fun main() {
    println(Solution3403().answerString("gh", 1))
    println(Solution3403().answerString("dbca", 2))
    println(Solution3403().answerString("gggg", 4))
}
