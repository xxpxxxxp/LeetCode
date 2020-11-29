package com.ypwang.medium

class Solution131 {
    fun partition(s: String): List<List<String>> {
        fun isPalindrome(i: Int, j: Int): Boolean {
            var i1 = i
            var j1 = j
            while (i1 < j1) {
                if (s[i1] != s[j1]) {
                    return false
                }

                i1++
                j1--
            }
            return true
        }

        val cache = mutableMapOf<Int, List<List<String>>>()

        fun partition(start: Int): List<List<String>> {
            if (start == s.length)
                return listOf(listOf())

            if (start in cache)
                return cache[start]!!

            val t = (start until s.length)
                    .filter { isPalindrome(start, it) }
                    .flatMap { partition(it + 1).map { l -> listOf(s.substring(start, it+1)) + l } }

            cache[start] = t
            return t
        }

        return partition(0)
    }
}

fun main() {
    println(Solution131().partition("aab"))
}