package com.ypwang.medium

class Solution3714 {
    fun longestBalanced(s: String): Int {
        val n = s.length
        var ans = 0
        var i = 0

        // Find longest same-character segment
        while (i < n) {
            var j = i
            while (j < n && s[j] == s[i])
                j++

            ans = maxOf(ans, j - i)
            i = j
        }

        // Helper function similar to C++ lambda
        fun best2(x: Char, y: Char): Int {
            var best = 0
            var i = 0
            while (i < n) {
                if (s[i] == y) {
                    i++
                    continue
                }
                val st = i
                var bal = 0
                val fst = mutableMapOf<Int, Int>()
                fst[0] = st
                var j = st
                while (j < n && s[j] != y) {
                    bal += if (s[j] == x) 1 else -1
                    if (fst.containsKey(bal))
                        best = maxOf(best, j + 1 - fst[bal]!!)
                    else
                        fst[bal] = j + 1
                    j++
                }
                i = j
            }
            return best
        }

        // Try all combinations
        ans = maxOf(ans, best2('a', 'c'))
        ans = maxOf(ans, best2('a', 'b'))
        ans = maxOf(ans, best2('b', 'a'))

        // Final 3-char comparison logic
        var ca = 0
        var cb = 0
        var cc = 0
        val mp = mutableMapOf<Pair<Int, Int>, Int>()
        mp[Pair(0, 0)] = -1

        for (i in 0 until n) {
            when (s[i]) {
                'a' -> ca++
                'b' -> cb++
                else -> cc++
            }
            val key = Pair(ca - cb, ca - cc)
            if (key in mp)
                ans = maxOf(ans, i - mp[key]!!)
            else
                mp[key] = i
        }

        return ans
    }
}
