package com.ypwang.easy

class Solution804 {
    companion object {
        val morse = listOf(".-","-...","-.-.","-..",".","..-.","--.","....","src",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
        val morseMap: Map<Char, String> by lazy {
            ('a'..'z').zip(morse).toMap()
        }
    }

    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val h = mutableSetOf<String>()
        for (w in words) {
            h.add(StringBuilder().apply {
                w.map { morseMap[it] }.forEach {
                    append(it)
                }
            }.toString())
        }
        return h.count()
    }
}

fun main() {
    println(Solution804().uniqueMorseRepresentations(arrayOf("gin", "zen", "gig", "msg")))
}