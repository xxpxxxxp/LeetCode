package com.ypwang.hard

class Solution3734 {
    fun lexPalindromicPermutation(s: String, target: String): String {
        val n = s.length

        val cnt = IntArray(26)
        for (c in s)
            cnt[c - 'a']++

        var midChar = ""
        var odd = 0
        for (i in 0 until 26) {
            if (cnt[i] % 2 != 0) {
                odd++
                midChar = ('a' + i).toString()
            }
        }

        if (odd > 1)
            return ""

        val halfCnt = IntArray(26) { cnt[it] / 2 }
        val nHalf = n / 2
        val halfStr = CharArray(nHalf)

        fun backtrack(k: Int, isGreater: Boolean): Boolean {
            if (k == nHalf) {
                val revHalf = halfStr.reversed()
                val res = halfStr.concatToString() + midChar + revHalf.joinToString("")
                return res > target
            }

            val startC = if (isGreater) 'a' else target[k]

            for (c in startC..'z') {
                val idx = c - 'a'
                if (halfCnt[idx] > 0) {
                    halfStr[k] = c
                    halfCnt[idx]--
                    if (backtrack(k + 1, isGreater || c > target[k]))
                        return true

                    halfCnt[idx]++
                }
            }
            return false
        }

        if (backtrack(0, false)) {
            val revHalf = halfStr.reversed()
            return halfStr.concatToString() + midChar + revHalf.joinToString("")
        }

        return ""
    }
}
