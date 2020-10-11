package com.ypwang.medium

class Solution1616 {
    private fun check(a: String, b: String): Boolean {
        var i = (a.length / 2) - 1
        while (i >= 0) {
            if (a[i] != a[a.lastIndex-i])
                break

            i--
        }

        return i < 0 ||
                a.substring(0, i+1) == b.substring(a.lastIndex-i).reversed() ||
                a.substring(a.lastIndex-i) == b.substring(0, i+1).reversed()
    }

    fun checkPalindromeFormation(a: String, b: String): Boolean = check(a, b) || check(b, a)
}