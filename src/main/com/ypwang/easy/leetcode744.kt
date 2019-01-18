package com.ypwang.easy

class Solution744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var i = 0
        var j = letters.lastIndex
        while (i <= j) {
            val m = (j - i) / 2 + i
            if (letters[m] > target) {
                j = m - 1
            } else {
                i = m + 1
            }
        }
        return if (i >= letters.size) letters[0] else letters[i]
    }
}