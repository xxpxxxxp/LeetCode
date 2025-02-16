package com.ypwang.medium

class Solution3458 {
    fun maxSubstringLength(s: String, k: Int): Boolean {
        val strLen = s.length
        if (k == 0)
            return true

        val firstOccur = IntArray(26) { strLen }
        val lastOccur = IntArray(26) { -1 }

        // Step 1: Find first and last occurrence of each character
        for ((pos, c) in s.withIndex()) {
            val charIdx = c - 'a'
            firstOccur[charIdx] = minOf(firstOccur[charIdx], pos)
            lastOccur[charIdx] = maxOf(lastOccur[charIdx], pos)
        }

        val segments = mutableListOf<IntArray>()
        for (start in 0 until strLen) {
            if (start != firstOccur[s[start] - 'a'])
                continue

            var farthest = lastOccur[s[start] - 'a']
            var current = start
            var isValid = true

            while (current <= farthest) {
                if (firstOccur[s[current] - 'a'] < start) {
                    isValid = false
                    break
                }

                farthest = maxOf(farthest, lastOccur[s[current] - 'a'])
                current++
            }

            if (isValid && !(start == 0 && farthest == strLen - 1))
                segments.add(intArrayOf(start, farthest))
        }

        // Step 3: Sort the segments based on ending index
        segments.sortBy { it[1] }

        // Step 4: Count non-overlapping segments
        var segmentCount = 0
        var lastIndex = -1
        for (bounds in segments) {
            if (bounds[0] > lastIndex) {
                segmentCount++
                lastIndex = bounds[1]
            }
        }

        return segmentCount >= k
    }
}

fun main() {
    println(Solution3458().maxSubstringLength("cdefdc", 3))
}