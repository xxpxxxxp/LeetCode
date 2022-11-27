package com.ypwang.hard

class Solution2484 {
    fun countPalindromes(s: String): Int {
        val n = s.length
        var totalCount = 0L

        // for palindromes of the form "cd.dc", we will check
        // every possible combination of "cd" from "00" to "99"
        for (c in '0'..'9') {
            for (d in '0'..'9') {
                // number of combinations of "cd." up to each index (inclusive)
                val startCount = LongArray(n)

                // number of combinations of "cd"
                var cBeforeD = 0L

                // number of "c"
                var cCount = 0

                // scan forwards to populate startCount
                for ((i, v) in s.withIndex()) {
                    startCount[i] = cBeforeD

                    // use multiple if instead of if/else for when c == d
                    if (v == d)
                        cBeforeD += cCount
                    if (v == c)
                        cCount++
                }

                // reset counts
                cBeforeD = 0
                cCount = 0

                // scan backwards to update totalCount, stop at i == 3
                // because startCount counts the first 3 characters "cd."
                for (i in n - 1 downTo 3) {
                    val ch = s[i]
                    if (ch == d)
                        cBeforeD += cCount
                    if (ch == c)
                        cCount++

                    // the update to totalCount is the number of combinations of "dc"
                    // encountered so far multiplied by the number of combinations
                    // of "cd." up to index i - 1
                    totalCount = (totalCount + cBeforeD * startCount[i - 1]) % 1000000007
                }
            }
        }
        return totalCount.toInt()
    }
}
