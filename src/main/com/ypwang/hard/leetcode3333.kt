package com.ypwang.hard

class Solution3333 {
    fun possibleStringCount(word: String, k: Int): Int {
        val MOD = 1000000007
        val wordLength = word.length
        val characterGroups = mutableListOf<Int>()

        var index = 0
        while (index < wordLength) {
            var characterCount = 1
            val currentCharacter = word[index++]
            while (index < wordLength && word[index] == currentCharacter) {
                characterCount++
                index++
            }
            characterGroups.add(characterCount)
        }

        val totalCombinations = characterGroups.fold(1L) { a, b -> (a * b) % MOD }

        if (k <= characterGroups.size)
            return totalCombinations.toInt()

        var dp = IntArray(k)
        dp[0] = 1
        for (count in characterGroups) {
            val newDP = IntArray(k)
            var cumulativeSum = 0L
            for (s in 0 until k) {
                if (s - 1 >= 0)
                    cumulativeSum = (cumulativeSum + dp[s - 1]) % MOD
                if (s - count - 1 >= 0)
                    cumulativeSum = (cumulativeSum - dp[s - count - 1] + MOD) % MOD
                newDP[s] = cumulativeSum.toInt()
            }
            dp = newDP
        }

        var totalLessThanK = (characterGroups.size until k).fold(0L) { a, i -> (a + dp[i]) % MOD }
        return ((totalCombinations - totalLessThanK + MOD) % MOD).toInt()
    }
}
