package com.ypwang.easy

class Solution1768 {
    fun mergeAlternately(word1: String, word2: String): String {
        val sb = StringBuilder()
        var i = 0
        var j = 0
        var count = 0
        while (i < word1.length && j < word2.length) {
            if (count++ % 2 == 0) {
                sb.append(word1[i++])
            } else {
                sb.append(word2[j++])
            }
        }

        sb.append(word1.substring(i))
        sb.append(word2.substring(j))

        return sb.toString()
    }
}