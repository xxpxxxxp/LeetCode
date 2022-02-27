package com.ypwang.easy

class Solution2185 {
    fun prefixCount(words: Array<String>, pref: String): Int = words.count { it.startsWith(pref) }
}