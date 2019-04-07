package com.ypwang.medium

class Solution809 {
    private fun helper(s: String): List<Pair<Char, Int>> {
        if (s.isEmpty())
            return listOf()

        val rst = mutableListOf<Pair<Char, Int>>()
        var cur = s.first()
        var len = 1
        for (i in 1 until s.length) {
            if (cur == s[i]) {
                len++
            } else {
                rst.add(Pair(cur, len))
                cur = s[i]
                len = 1
            }
        }
        rst.add(Pair(cur, len))

        return rst
    }

    fun expressiveWords(S: String, words: Array<String>): Int {
        val patten = helper(S)

        var count = 0
        for (word in words) {
            var match = true
            val m = helper(word).iterator()
            val patternIter = patten.iterator()
            while (patternIter.hasNext()) {
                if (!m.hasNext()) {
                    match = false
                    break
                }

                val mn = m.next()
                val pn = patternIter.next()
                if (!(mn.first == pn.first && ((pn.second < 3 && pn.second == mn.second) || (pn.second >= 3 && mn.second <= pn.second)))) {
                    match = false
                    break
                }
            }

            if (match && !m.hasNext())
                count++
        }

        return count
    }
}

fun main() {
    println(Solution809().expressiveWords("heeellooo", arrayOf("hello", "hi", "helo")))
}