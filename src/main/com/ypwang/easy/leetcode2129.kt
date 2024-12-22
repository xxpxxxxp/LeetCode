package com.ypwang.easy

class Solution2129 {
    fun capitalizeTitle(title: String): String =
        title.split(' ').joinToString(" ") {
            if (it.length < 3) it.lowercase()
            else it.lowercase().capitalize()
        }
}