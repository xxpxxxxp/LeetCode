package com.ypwang.easy

class Solution3330 {
    fun possibleStringCount(word: String): Int {
        var i = 0
        var j = 0

        var count = 1
        while (i < word.length) {
            while (j < word.length && word[j] == word[i])
                j++

            count += j - i - 1
            i = j
        }

        return count
    }
}

fun main() {
    println(Solution3330().possibleStringCount("abbcccc"))
}
