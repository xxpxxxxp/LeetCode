package com.ypwang.medium

class Solution3713 {
    private fun solve(mp: MutableMap<Char, Int>): Boolean {
        if (mp.isEmpty())
            return false

        var mini = Int.MAX_VALUE
        var maxi = Int.MIN_VALUE
        for (v in mp.values) {
            mini = minOf(mini, v)
            maxi = maxOf(maxi, v)
        }

        return mini == maxi
    }

    fun longestBalanced(s: String): Int {
        val n = s.length
        var ans = 0
        for (i in 0 until n) {
            val mp = mutableMapOf<Char, Int>()
            for (j in i until n) {
                val ch = s[j]
                mp[ch] = mp.getOrDefault(ch, 0) + 1
                if (solve(mp))
                    ans = maxOf(ans, j - i + 1)
            }
        }

        return ans
    }
}
