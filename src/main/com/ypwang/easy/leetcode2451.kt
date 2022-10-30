package com.ypwang.easy

class Solution2451 {
    fun oddString(words: Array<String>): String =
        words.groupBy {
            val diff = mutableListOf<Int>()
            for (i in 0 until it.length - 1)
                diff.add(it[i+1] - it[i])
            diff.hashCode()
        }.filter { it.value.size == 1 }.toList().single().second.single()
}