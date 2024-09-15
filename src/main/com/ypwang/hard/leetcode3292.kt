package com.ypwang.hard

class Solution3292 {
    fun prefixFunction(s: String): List<Int> {
        val n = s.length
        val pi = MutableList(n) { 0 }
        for (i in 1 until n) {
            var j = pi[i - 1]
            while (j > 0 && s[i] != s[j])
                j = pi[j - 1]
            if (s[i] == s[j])
                j++
            pi[i] = j
        }
        return pi
    }

    fun minValidStrings(words: Array<String>, target: String): Int {
        val pis = mutableListOf<List<Int>>()
        for (w in words)
            pis.add(prefixFunction(w + "#" + target))

        var len = target.length
        var res = 0
        while (len > 0) {
            var match = 0
            for (i in 0 until words.size)
                match = maxOf(match, pis[i][words[i].length + len])

            if (match == 0)
                return -1
            res++
            len -= match
        }
        return res
    }
}
