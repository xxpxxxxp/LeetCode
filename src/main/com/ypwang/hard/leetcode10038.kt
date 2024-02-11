package com.ypwang.hard

class Solution10038 {
    fun maxPartitionsAfterOperations(s: String, k: Int): Int {
        val cache = mutableMapOf<Long, Int>()

        fun dp(index: Int, currentSet: Int, canChange: Boolean): Int {
            val key = (index.toLong() shl 27) or (currentSet.toLong() shl 1) or (if (canChange) 1 else 0).toLong()

            if (key in cache)
                return cache[key]!!

            if (index == s.length)
                return 0

            val characterIndex = s[index] - 'a'
            val currentSetUpdated = currentSet or (1 shl characterIndex)

            var res = if (currentSetUpdated.countOneBits() > k)
                1 + dp(index + 1, 1 shl characterIndex, canChange)
            else
                dp(index + 1, currentSetUpdated, canChange)

            if (canChange) {
                for (newCharIndex in 0..25) {
                    val newSet = currentSet or (1 shl newCharIndex)
                    res = if (newSet.countOneBits() > k)
                        maxOf(res, 1 + dp(index + 1, 1 shl newCharIndex, false))
                    else
                        maxOf(res, dp(index + 1, newSet, false))
                }
            }

            return res.also { cache[key] = it }
        }

        return dp(0, 0, true) + 1
    }
}
