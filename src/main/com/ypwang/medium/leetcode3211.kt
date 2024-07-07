package com.ypwang.medium

class Solution3211 {
    fun validStrings(n: Int): List<String> =
        (0 until n).fold(listOf("")) { p, _ ->
            p.flatMap {
                if (it.lastOrNull() == '0')
                    listOf(it + "1")
                else
                    listOf(it + "0", it + "1")
            }
        }
}
