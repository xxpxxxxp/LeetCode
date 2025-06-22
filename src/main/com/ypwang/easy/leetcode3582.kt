package com.ypwang.easy

class Solution3582 {
    fun generateTag(caption: String): String =
        "#" + caption.split(' ').joinToString("") { it.lowercase(java.util.Locale.getDefault()).capitalize() }.replaceFirstChar { it.lowercaseChar() }.take(99)
}
