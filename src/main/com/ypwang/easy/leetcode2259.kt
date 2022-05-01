package com.ypwang.easy

class Solution {
    fun removeDigit(number: String, digit: Char): String {
        var j = 0
        for ((i, v) in number.withIndex()) {
            if (v == digit) {
                if (i+1 < number.length && v < number[i+1])
                    return number.substring(0, i) + number.substring(i+1)

                j = i
            }
        }

        return number.substring(0, j) + number.substring(j+1)
    }
}