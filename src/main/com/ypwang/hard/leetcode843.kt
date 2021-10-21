package com.ypwang.hard

interface Master {
    fun guess(word: String): Int
}

class Solution843 {
    fun findSecretWord(wordlist: Array<String>, master: Master) {
        val matches = Array(wordlist.size){ IntArray(wordlist.size) }
        for (i in wordlist.indices) {
            for (j in wordlist.indices) {
                matches[i][j] = (0 until 6).count { wordlist[i][it] == wordlist[j][it] }
            }
        }

        var possible = wordlist.indices.toList()
        while (possible.isNotEmpty()) {
            val guess = possible.map { guess ->
                guess to possible.groupBy { each -> matches[each][guess] }.map { it.value.size }.maxOrNull()!!
            }.minByOrNull { it.second }!!.first

            val match = master.guess(wordlist[guess])
            if (match == 6) return
            possible = possible.filter { matches[guess][it] == match }
        }
    }
}

fun main() {
    println(Solution843().findSecretWord(arrayOf("acckzz","ccbazz","eiowzz","abcczz"), object: Master {
        override fun guess(word: String): Int {
            println("Call")
            return "acckzz".zip(word).count { it.first == it.second }
        }
    }))
}