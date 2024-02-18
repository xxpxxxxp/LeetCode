package com.ypwang.medium

class Solution3043 {
    class Trie() {
        val sub = mutableMapOf<Char, Trie>()
    }

    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val root = Trie()

        for (i in arr1) {
            val s = i.toString()
            var cur = root
            for (c in s) {
                if (c !in cur.sub)
                    cur.sub[c] = Trie()

                cur = cur.sub[c]!!
            }
        }

        var rst = 0
        for (i in arr2) {
            val s = i.toString()
            var cur: Trie? = root
            for ((j, c) in s.withIndex()) {
                cur = cur!!.sub.get(c)

                if (cur == null) {
                    rst = maxOf(rst, j)
                    break
                }
            }

            if (cur != null)
                rst = maxOf(rst, s.length)
        }

        return rst
    }
}

fun main() {
    println(Solution3043().longestCommonPrefix(intArrayOf(5), intArrayOf(33)))
    println(Solution3043().longestCommonPrefix(intArrayOf(17), intArrayOf(16)))
    println(Solution3043().longestCommonPrefix(intArrayOf(1, 10, 100), intArrayOf(1000)))
}