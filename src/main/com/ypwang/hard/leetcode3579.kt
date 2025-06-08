package com.ypwang.hard

class Solution3579 {
    val mod = 1_000_000_007

    fun minOperations(word1: String, word2: String): Int {
        val n = word1.length
        val dp = IntArray(n + 1) { -1 }

        fun helper(s: String, t: String): Int {
            var cnt = 0
            val m = s.length
            val st = mutableListOf<Pair<Char, Char>>()

            for (ind in 0 until m) {
                if (s[ind] != t[ind]) {
                    val target = Pair(t[ind], s[ind])
                    val it = st.indexOf(target)
                    if (it != -1) {
                        st.removeAt(it)
                        cnt++
                    } else {
                        st.add(Pair(s[ind], t[ind]))
                    }
                }
            }
            return cnt + st.size
        }

        fun solve(ind: Int, s1: String, s2: String): Int {
            if (ind == n)
                return 0
            if (dp[ind] != -1)
                return dp[ind]

            var ans = Int.MAX_VALUE
            val s = StringBuilder()
            val t = StringBuilder()

            for (i in ind until n) {
                s.append(s1[i])
                t.append(s2[i])
                var cnt = helper(s.toString(), t.toString())

                // Reverse s and try again
                s.reverse()
                cnt = minOf(cnt, 1 + helper(s.toString(), t.toString()))
                s.reverse()

                ans = minOf(ans, cnt + solve(i + 1, s1, s2))
            }
            dp[ind] = ans
            return ans
        }

        return solve(0, word1, word2)
    }
}
