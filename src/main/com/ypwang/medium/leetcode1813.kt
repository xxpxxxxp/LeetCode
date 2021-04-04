package com.ypwang.medium

class Solution1813 {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        val s1 = sentence1.split(' ').toTypedArray()
        val s2 = sentence2.split(' ').toTypedArray()

        val (short, long) =
            if (s1.size < s2.size) s1 to s2
            else s2 to s1

        var i = 0
        while (i < short.size && short[i] == long[i])
            i++

        var j = short.size
        while (j > i && short[j-1] == long[long.size + j - 1 - short.size])
            j--

        return i == j
    }
}

fun main() {
    println(Solution1813().areSentencesSimilar("My name is Haley", "My Haley"))
    println(Solution1813().areSentencesSimilar(sentence1 = "of", sentence2 = "A lot of words"))
    println(Solution1813().areSentencesSimilar(sentence1 = "Eating right now", sentence2 = "Eating"))
    println(Solution1813().areSentencesSimilar(sentence1 = "Luky", sentence2 = "Lucccky"))
}