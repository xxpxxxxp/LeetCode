package com.ypwang.easy

class Solution1170 {
    private fun helper(target: IntArray, num: Int): Int {
        var l = 0
        var r = target.size

        while (l < r) {
            val mid = (l + r) / 2
            if (target[mid] > num) r = mid
            else l = mid + 1
        }

        return target.size - l
    }

    fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
        val tmp = IntArray(26)
        val target = IntArray(words.size)

        for ((i, word) in words.withIndex()) {
            tmp.fill(0)
            for (c in word) {
                tmp[c - 'a']++
            }
            target[i] = tmp.first { it > 0 }
        }
        target.sort()

        val rst = IntArray(queries.size)
        for ((i, query) in queries.withIndex()) {
            tmp.fill(0)
            for (c in query) {
                tmp[c - 'a']++
            }
            rst[i] = helper(target, tmp.first { it > 0 })
        }

        return rst
    }
}

fun main() {
    println(Solution1170().numSmallerByFrequency(arrayOf("aabbabbb","abbbabaa","aabbbabaa","aabba","abb","a","ba","aa","ba","baabbbaaaa","babaa","bbbbabaa"), arrayOf("b","aaaba","aaaabba","aa","aabaabab","aabbaaabbb","ababb","bbb","aabbbabb","aab","bbaaababba","baaaaa")).toList())
    println(Solution1170().numSmallerByFrequency(arrayOf("cbd"), arrayOf("zaaaz")).toList())
    println(Solution1170().numSmallerByFrequency(arrayOf("bbb","cc"), arrayOf("a","aa","aaa","aaaa")).toList())
    println(Solution1170().numSmallerByFrequency(arrayOf("bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"), arrayOf("aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa")).toList())
}