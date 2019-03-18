package com.ypwang.medium

class Solution299 {
    fun getHint(secret: String, guess: String): String {
        val ms = mutableMapOf<Char, Int>()
        val mg = mutableMapOf<Char, Int>()
        var bulls = 0

        for (i in 0 until secret.length) {
            if (secret[i] == guess[i]) {
                bulls++
            } else {
                ms[secret[i]] = ms.getOrDefault(secret[i], 0) + 1
                mg[guess[i]] = mg.getOrDefault(guess[i], 0) + 1
            }
        }

        return "${bulls}A${ ms.map { minOf(it.value, mg.getOrDefault(it.key, 0)) }.sum() }B"
    }
}

fun main() {
    println(Solution299().getHint("1123", "0111"))
}