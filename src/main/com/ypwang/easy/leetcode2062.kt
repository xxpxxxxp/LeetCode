package com.ypwang.easy

class Solution2062 {
    private val vowels = setOf('a', 'e', 'i', 'o', 'u')

    private fun helper(word: String, c: Int): Pair<Int, Int> {
        var j = c
        var i = c
        var rst = 0
        val count = mutableMapOf<Char, Int>()

        while (i < word.length) {
            val char = word[i]
            if (char !in vowels)
                break

            count[char] = 1 + count.getOrDefault(char, 0)
            if (count.size == 5) {
                while (count.size == 5) {
                    val c1 = word[j++]
                    count[c1] = count[c1]!! - 1
                    if (count[c1]!! == 0)
                        count.remove(c1)
                }
            }

            rst += j - c
            i++
        }

        return rst to i
    }

    fun countVowelSubstrings(word: String): Int {
        var rst = 0
        var i = 0

        while (i < word.length) {
            if (word[i] in vowels) {
                val (r, j) = helper(word, i)
                rst += r
                i = j
            } else
                i++
        }

        return rst
    }
}

fun main() {
    println(Solution2062().countVowelSubstrings("aeiouu"))
    println(Solution2062().countVowelSubstrings("unicornarihan"))
    println(Solution2062().countVowelSubstrings("cuaieuouac"))
    println(Solution2062().countVowelSubstrings("bbaeixoubb"))
}