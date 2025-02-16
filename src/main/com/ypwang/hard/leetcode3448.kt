package com.ypwang.hard

class Solution3448 {
    fun countSubstrings(s: String): Long {
        val n = s.length
        var ans = 0L
        val P3 = IntArray(n)
        val P7 = IntArray(n)
        val P9 = IntArray(n)

        P3[0] = (s[0] - '0') % 3
        P7[0] = (s[0] - '0') % 7
        P9[0] = (s[0] - '0') % 9

        for (i in 1 until n) {
            val dig = s[i] - '0'
            P3[i] = (P3[i - 1] * 10 + dig) % 3
            P7[i] = (P7[i - 1] * 10 + dig) % 7
            P9[i] = (P9[i - 1] * 10 + dig) % 9
        }

        val freq3 = LongArray(3)
        val freq9 = LongArray(9)
        val freq7 = Array(6) { LongArray(7) }
        val inv7 = intArrayOf(1, 5, 4, 6, 2, 3)

        for (j in 0 until n) {
            val d = s[j] - '0'
            when (d) {
                1, 2, 5 -> ans += (j + 1).toLong()
                4 -> {
                    if (j == 0) ans += 1
                    else {
                        val num = (s[j - 1] - '0') * 10 + d
                        ans += if (num % 4 == 0) (j + 1).toLong() else 1
                    }
                }
                8 -> {
                    if (j == 0) ans += 1
                    else if (j == 1) {
                        val num = (s[0] - '0') * 10 + 8
                        ans += if (num % 8 == 0) 2L else 1
                    } else {
                        val num3 = (s[j - 2] - '0') * 100 + (s[j - 1] - '0') * 10 + 8
                        val num2 = (s[j - 1] - '0') * 10 + 8
                        ans += ((if (num3 % 8 == 0) (j - 1) else 0) +
                                (if (num2 % 8 == 0) 1 else 0) + 1).toLong()
                    }
                }
                3, 6 -> ans += (if (P3[j] == 0) 1L else 0L) + freq3[P3[j]]
                7 -> {
                    ans += if (P7[j] == 0) 1L else 0L
                    for (m in 0 until 6) {
                        val idx = ((j % 6) - m + 6) % 6
                        val req = (P7[j] * inv7[m]) % 7
                        ans += freq7[idx][req]
                    }
                }
                9 -> ans += (if (P9[j] == 0) 1L else 0L) + freq9[P9[j]]
            }
            freq3[P3[j]]++
            freq7[j % 6][P7[j]]++
            freq9[P9[j]]++
        }
        return ans
    }
}

fun main() {
    println(Solution3448().countSubstrings("12936"))
}