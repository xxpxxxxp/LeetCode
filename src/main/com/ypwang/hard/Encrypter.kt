package com.ypwang.hard

class Encrypter(keys: CharArray, values: Array<String>, dictionary: Array<String>) {
    private val emp = keys.zip(values).toMap()
    private val ed = dictionary.map { encrypt(it) }.groupBy { it }.mapValues { it.value.size }

    fun encrypt(word1: String): String = word1.map { emp[it]!! }.joinToString("")
    fun decrypt(word2: String): Int = ed.getOrDefault(word2, 0)
}