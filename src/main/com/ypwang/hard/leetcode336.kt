package com.ypwang.hard

class Solution336 {
    class Trie(val c: Char, var isWord: Int = -1) {
        val idx = mutableListOf<Int>()
        val sub = Array<Trie?>(26){null}
    }

    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val root = Trie('0')
        val rst = mutableListOf<List<Int>>()

        for ((i, word) in words.withIndex()) {
            var r = root
            for (c in word.reversed()) {
                val z = c - 'a'
                if (r.sub[z] == null) r.sub[z] = Trie(c)
                r = r.sub[z]!!
                r.idx.add(i)
            }
            r.isWord = i
        }

        for ((i, word) in words.withIndex()) {
            var r: Trie? = root
            for ((j, c) in word.withIndex()) {
                if (r!!.isWord >= 0) {
                    // check if current left is palindrome
                    if (isPalindrome(word, j, word.length)) rst.add(listOf(i, r!!.isWord))
                }

                val z = c - 'a'
                r = r!!.sub[z]
                if (r == null) break
            }

            if (r != null) {
                if (r.sub.all { it == null }) rst.addAll(r.idx.filter { it != i }.map { listOf(i, it) })
                else {
                    if (r.isWord >= 0 && r.isWord != i) rst.add(listOf(i, r.isWord))
                    for (j in r.sub.filterNotNull().flatMap { it.idx }) {
                        if (isPalindrome(words[j], 0, words[j].length - word.length))
                            rst.add(listOf(i, j))
                    }
                }
            }
        }

        return rst
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        var i = start
        var j = end - 1
        while (i < j) {
            if (s[i] != s[j]) return false
            i++
            j--
        }
        return true
    }
}

fun main() {
    println(Solution336().palindromePairs(arrayOf("ab","ba","abc","cba")))
    println(Solution336().palindromePairs(arrayOf("a","b","c","ab","ac","aa")))
    println(Solution336().palindromePairs(arrayOf("a","abc","aba","")))
    println(Solution336().palindromePairs(arrayOf("a","")))
    println(Solution336().palindromePairs(arrayOf("abcd","dcba","lls","s","sssll")))
    println(Solution336().palindromePairs(arrayOf("bat","tab","cat")))
}