package com.ypwang.medium

class Solution3306 {
    fun countOfSubstrings(word: String, k: Int): Long {
        fun countAtLeastMConsonants(m: Int): Long {
            val n = word.length
            val vowels = setOf('a', 'e', 'i', 'o', 'u')
            val vowelsMap = mutableMapOf<Char, Int>()
            var numConsonants = 0
            var ans = 0L
            var l = 0
            var r = 0

            while (r < n || l < r) {
                if (vowelsMap.size == 5 && numConsonants >= m) {
                    ans += n - r + 1
                    if (word[l] !in vowels)
                        numConsonants--
                    else {
                        vowelsMap[word[l]] = vowelsMap.getOrDefault(word[l], 0) - 1
                        if (vowelsMap[word[l]] == 0)
                            vowelsMap.remove(word[l])
                    }
                    l++
                } else {
                    if (r == n)
                        break
                    if (word[r] !in vowels)
                        numConsonants++
                    else
                        vowelsMap[word[r]] = vowelsMap.getOrDefault(word[r], 0) + 1
                    r++
                }
            }

            return ans
        }

        return countAtLeastMConsonants(k) - countAtLeastMConsonants(k + 1)
    }
}
