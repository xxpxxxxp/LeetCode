package com.ypwang.hard

class Solution3260 {
    fun largestPalindrome(n: Int, k: Int): String {
        if (k == 1)
            return "9".repeat(n)
        if (k == 2) {
            return when (n) {
                1, 2 -> "8".repeat(n)
                else -> "8" + "9".repeat(n - 2) + "8"
            }
        }
        if (k == 3 || k == 9)
            return "9".repeat(n)
        if (k == 4) {
            return when (n) {
                1, 2, 3, 4 -> "8".repeat(n)
                else -> "88" + "9".repeat(n - 4) + "88"
            }
        }
        if (k == 5) {
            return when (n) {
                1, 2 -> "5".repeat(n)
                else -> "5" + "9".repeat(n - 2) + "5"
            }
        }
        if (k == 6) {
            if (n <= 2)
                return "6".repeat(n)
            else if (n % 2 == 1) {
                val l = n / 2 - 1
                return "8" + "9".repeat(l) + "8" + "9".repeat(l) + "8"
            } else {
                val l = n / 2 - 2
                return "8" + "9".repeat(l) + "77" + "9".repeat(l) + "8"
            }
        }
        if (k == 8) {
            return when (n) {
                1, 2, 3, 4, 5, 6 -> "8".repeat(n)
                else -> "888" + "9".repeat(n - 6) + "888"
            }
        }

        val dic = arrayOf("", "7", "77", "959", "9779", "99799", "999999",
            "9994999", "99944999", "999969999", "9999449999", "99999499999")
        val l = n / 12
        val r = n % 12
        return "999999".repeat(l) + dic[r] + "999999".repeat(l)
    }
}
