package com.ypwang.medium

class Solution3295 {
    fun reportSpam(message: Array<String>, bannedWords: Array<String>): Boolean {
        val ban = bannedWords.toSet()
        return message.count { it in ban } >= 2
    }
}
