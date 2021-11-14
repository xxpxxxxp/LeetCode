package com.ypwang.medium

import java.lang.StringBuilder

class Solution2075 {
    fun decodeCiphertext(encodedText: String, rows: Int): String {
        val size = encodedText.length / rows
        val idxs = IntArray(rows) { it * (size + 1) }

        val sb = StringBuilder()

        for (i in 0 until size) {
            for (j in idxs.indices) {
                if (idxs[j] < encodedText.length)
                    sb.append(encodedText[idxs[j]++])
            }
        }

        return sb.toString().trimEnd()
    }
}

fun main() {
    println(Solution2075().decodeCiphertext("ch   ie   pr", 3))
}