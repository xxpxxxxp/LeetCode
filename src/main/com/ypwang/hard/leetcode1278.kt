package com.ypwang.hard

class Solution1278 {
    fun palindromePartition(s: String, k: Int): Int {
        fun palindrome(i: Int, j: Int): Int {
            var cnt = 0
            var ii = i
            var jj = j
            while (ii < jj) {
                if (s[ii] != s[jj]) cnt++
                ii++
                jj--
            }
            return cnt
        }

        val pdp = Array(s.length){ IntArray(s.length){-1} }
        val rdp = Array(s.length+1){ IntArray(k+1) }
        for (i in s.indices) rdp[i+1][0] = 10000

        for (i in 1..s.length) {
            for (j in 1..k) {
                if (i <= j) {
                    rdp[i][j] = 0
                } else {
                    rdp[i][j] = Int.MAX_VALUE
                    for (z in 1..i) {
                        if (pdp[z-1][i-1] == -1) {
                            pdp[z-1][i-1] = palindrome(z-1, i-1)
                        }

                        rdp[i][j] = minOf(rdp[i][j], rdp[z-1][j-1] + pdp[z-1][i-1])
                    }
                }
            }
        }

        return rdp.last().last()
    }
}

fun main() {
    println(Solution1278().palindromePartition("abc", 2))
    println(Solution1278().palindromePartition("aabbc", 3))
    println(Solution1278().palindromePartition("leetcode", 8))
}