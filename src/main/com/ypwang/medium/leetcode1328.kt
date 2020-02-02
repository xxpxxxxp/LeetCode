package com.ypwang.medium

class Solution1328 {
    fun breakPalindrome(palindrome: String): String {
        val len = palindrome.length
        for (i in palindrome.indices) {
            if (palindrome[i] != 'a' && i * 2 + 1 != len)
                return palindrome.substring(0, i) + "a" + palindrome.substring(i+1)
        }

        return if (len == 1) "" else palindrome.substring(0, len-1) + "b"
    }
}