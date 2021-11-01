package com.ypwang.easy

class Solution2053 {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        var kk = k
        val count = arr.groupBy { it }.mapValues { it.value.size }
        for (word in arr) {
            if (count[word]!! > 1)
                continue

            if (--kk == 0)
                return word
        }

        return ""
    }
}

fun main() {
    println(Solution2053().kthDistinct(arrayOf("d","b","c","b","c","a"), 2))
}