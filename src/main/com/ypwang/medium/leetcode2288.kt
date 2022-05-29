package com.ypwang.medium

class Solution2288 {
    fun discountPrices(sentence: String, discount: Int): String =
        sentence.split(' ').map {
            if (it.length > 1 && it.startsWith('$') && it.substring(1).toDoubleOrNull() != null) {
                "$" + "%.2f".format(it.substring(1).toDouble() * (100 - discount) / 100)
            } else {
                it
            }
        }.joinToString(" ")
}