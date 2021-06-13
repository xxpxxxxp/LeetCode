package com.ypwang.easy

class Solution1897 {
    fun makeEqual(words: Array<String>): Boolean {
        val count = IntArray(26)
        for (word in words) {
            for (c in word) {
                count[c-'a']++
            }
        }

        return count.all { it % words.size == 0 }
    }
}