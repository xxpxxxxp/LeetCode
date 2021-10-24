package com.ypwang.easy

class Solution2047 {
    fun countValidWords(sentence: String): Int =
        sentence.split(' ')
            .filter { it.isNotEmpty() }
            .count { word ->
                val trim =
                    if (word.last() in setOf('!', '.', ','))
                        word.substring(0, word.lastIndex)
                    else
                        word

                trim.all { it.isLetter() || it == '-' } && trim.count { it == '-' } < 2 && (
                        trim.isEmpty() || (trim.first() != '-' && trim.indexOf('-') in -1 until trim.lastIndex))
            }
}