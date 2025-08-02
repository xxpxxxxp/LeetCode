package com.ypwang.easy

class Solution3602 {
    fun concatHex36(n: Int): String =
        (n * n).toString(16).uppercase(java.util.Locale.getDefault()) + (n * n * n).toString(36).uppercase(java.util.Locale.getDefault())
}
